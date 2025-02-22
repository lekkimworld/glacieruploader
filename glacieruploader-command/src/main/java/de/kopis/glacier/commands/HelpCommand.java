package de.kopis.glacier.commands;

/*
 * #%L
 * glacieruploader-command
 * %%
 * Copyright (C) 2012 - 2016 Carsten Ringe
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the 
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public 
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

import de.kopis.glacier.parsers.GlacierUploaderOptionParser;
import joptsimple.OptionSet;

import java.io.IOException;
import java.io.OutputStream;

public class HelpCommand extends AbstractCommand {

    private final OutputStream out;

    public HelpCommand() {
        this(System.out);
    }

    public HelpCommand(final OutputStream out) {
        super();
        this.out = out;
    }

    @Override
    public void exec(OptionSet options, GlacierUploaderOptionParser optionParser) {
        if (!options.has(optionParser.help)) {
            log.info("Ooops, can't determine what you want to do. Check your options." +
                    System.getProperty("line.separator"));
        }
        try {
            optionParser.printHelpOn(out);
        } catch (final IOException e) {
            log.error("Can not print help", e);
        }
    }

    @Override
    public boolean valid(OptionSet options, GlacierUploaderOptionParser optionParser) {
        return options.has(optionParser.help);
    }

}
