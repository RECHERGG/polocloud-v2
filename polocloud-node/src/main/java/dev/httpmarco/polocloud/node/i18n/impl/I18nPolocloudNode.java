package dev.httpmarco.polocloud.node.i18n.impl;

import dev.httpmarco.polocloud.node.i18n.I18nProvider;
import org.fusesource.jansi.AnsiConsole;

public final class I18nPolocloudNode extends I18nProvider {

    public I18nPolocloudNode() {
        super("i18n/polocloud-node");

        AnsiConsole.systemInstall();
    }
}
