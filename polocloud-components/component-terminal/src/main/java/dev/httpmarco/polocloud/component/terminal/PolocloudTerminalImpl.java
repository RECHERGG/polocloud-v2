package dev.httpmarco.polocloud.component.terminal;

import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.impl.LineReaderImpl;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public final class PolocloudTerminalImpl implements PolocloudTerminal {

    private Terminal terminal;
    private LineReaderImpl lineReader;
    private PolocloudTerminalThread terminalThread;

    @Override
    public void start() {
        try {
            terminal = TerminalBuilder.builder()
                    .system(true)
                    .encoding(StandardCharsets.UTF_8)
                    .dumb(true)
                    .jansi(true)
                    .build();
        } catch (IOException ex) {
            throw new RuntimeException("Cannot build Terminal!", ex);
        }

        this.lineReader = (LineReaderImpl) LineReaderBuilder.builder()
                .terminal(this.terminal)
                .option(LineReader.Option.AUTO_MENU_LIST, true)
                .variable(LineReader.COMPLETION_STYLE_LIST_SELECTION, "fg:cyan")
                .variable(LineReader.COMPLETION_STYLE_LIST_BACKGROUND, "fg:default")
                .option(LineReader.Option.DISABLE_EVENT_EXPANSION, true)
                .option(LineReader.Option.AUTO_PARAM_SLASH, false)
                .variable(LineReader.BELL_STYLE, "none")
                .build();

        (terminalThread = new PolocloudTerminalThread(this)).start();
    }

    @Override
    public void close() throws Exception {
        terminal.close();
        terminal = null;

        lineReader = null;

        terminalThread.interrupt();
        terminalThread = null;
    }

    @Override
    public void handleInput(String commandName, String[] args) {
        TerminalComponent.instance().commandService().call(commandName, args);
    }

    @Override
    public String prompt() {
        return "local@node";
    }

    @Override
    public void prompt(String prompt) {
        this.lineReader.setPrompt(prompt);
    }

    @Override
    public LineReader lineReader() {
        return lineReader;
    }
}
