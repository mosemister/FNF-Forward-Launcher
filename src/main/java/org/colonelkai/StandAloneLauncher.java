package org.colonelkai;

import org.colonelkai.file.DataFileType;
import org.colonelkai.file.simple.SimpleRootDataNode;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class StandAloneLauncher {

    public static void main(String[] args) {
        if (args.length != 0) {
            if (args[0].equalsIgnoreCase("--specifiedVersion")) {
                StringBuilder builder = new StringBuilder();
                for (int A = 1; A < args.length; A++) {
                    builder.append(args[A]);
                }
                SimpleRootDataNode rootNode = new SimpleRootDataNode();
                rootNode.at("ID", "FNF-Forward-Launcher");
                rootNode.at("Version", builder.toString());

                File file = new File("src/main/resources/meta/Info.json");
                try {
                    Files.createDirectories(file.getParentFile().toPath());
                    Files.createFile(file.toPath());
                    DataFileType.JSON.createFile().build(rootNode, file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.exit(0);
                return;
            }
        }

        ForwardLauncher.main(args);
    }
}
