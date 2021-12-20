package ObjectandClasses.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Songs {
    static class Song{
        private String typeList;
        private String name;
        private String time;
        public Song (String typeList, String name, String time){
            this.typeList = typeList;
            this.name = name;
            this.time = time;
        }

        public String getName() {
            return name;
        }

        public String getTypeList() {
            return typeList;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Song> songList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
        String[] input = scanner.nextLine().split("_");

        String typeList = input[0];
        String name = input[1];
        String time = input[2];

        Song currentSong = new Song(typeList, name, time);
        songList.add(currentSong);

        }
        String lastCommand = scanner.nextLine();


        if (lastCommand.equals("all")){
            for (Song song: songList) {
                System.out.println(song.getName());
            }
        }else {
        for (Song song: songList) {
            if (lastCommand.equals(song.getTypeList())){
                System.out.println(song.getName());
            }

        }
        }

    }
}
