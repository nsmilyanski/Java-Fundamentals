package testing;

import java.util.*;

public class ThePianist {

    static class playlist {
        String masterpiece, composer, key;

        public playlist(String masterpiece, String composer, String key) {
            this.masterpiece = masterpiece;
            this.composer = composer;
            this.key = key;
        }
        public String getMasterpiece() { return masterpiece; }
        public String getComposer() { return composer; }
        public String getKey() { return key; }
        public void setComposer(String composer) { this.composer = composer; }
        public void setKey(String key) { this.key = key; }
        public void setMasterpiece(String masterpiece) { this.masterpiece = masterpiece; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pieces = Integer.parseInt(sc.nextLine());
        List<playlist> masterpieces = new ArrayList<>();
        for (int x = 0; x < pieces; x++) {
            String[] input = sc.nextLine().split("\\|");
            masterpieces.add(new playlist(input[0], input[1], input[2]));
        }
        String input = sc.nextLine();
        while (!input.equals("Stop")) {
            String[] commandLine = input.split("\\|");
            switch (commandLine[0]) {
                case "Add":
                    boolean stop = false;
                    for (playlist item: masterpieces) {
                        if (item.getMasterpiece().equals(commandLine[1])) {
                            System.out.println(item.getMasterpiece() + " is already in the collection!");
                            stop = true; break;
                        }
                    }
                    if (!stop) {
                        masterpieces.add(new playlist(commandLine[1], commandLine[2], commandLine[3]));
                        System.out.println(commandLine[1] + " by " + commandLine[2] + " in " + commandLine[3] + " added to the collection!");
                    }
                    break;
                case "Remove":
                    boolean notExist = true;
                    for (playlist item: masterpieces) {
                        if (item.getMasterpiece().equals(commandLine[1])) {
                            notExist = false;
                            masterpieces.remove(item);
                            System.out.println("Successfully removed " + commandLine[1] + "!"); break;
                        }
                    }
                    if (notExist) { System.out.println("Invalid operation! " + commandLine[1] + " does not exist in the collection."); }
                    break;
                case "ChangeKey":
                    boolean isThere = false;
                    for (playlist item : masterpieces) {
                        if (item.getMasterpiece().equals(commandLine[1])) {
                            isThere = true; item.setKey(commandLine[2]);
                            System.out.printf("Changed the key of %s to %s!%n", commandLine[1], commandLine[2]); break;
                        }
                    }
                    if (!isThere) { System.out.println("Invalid operation! " + commandLine[1] + " does not exist in the collection."); }
                    break;
            }
            input = sc.nextLine();
        }
        masterpieces.stream().sorted((e1,e2) -> e1.getMasterpiece().compareTo(e2.getMasterpiece())).forEach(piece ->
                System.out.printf("%s -> Composer: %s, Key: %s%n", piece.getMasterpiece(), piece.getComposer(), piece.getKey()));
        System.out.println();
    }
}