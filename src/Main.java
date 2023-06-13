import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {

       Album album1 = new Album("Butta Bomma", "KD Reddy");
       Album album2 = new Album("Doorie", "Durjyo Reddy");

       album1.addSong("Butta Bomma", 4.3);
       album1.addSong("Ramulo Ramula", 3.5);

       album2.addSong("Doorie", 3.1);
       album2.addSong("Kuch Is Tarah", 3.2);
       album2.addSong("Mahi ve", 5.3);
       album2.addSong("Mahi ve", 5.3);

       if(album1.findSong("abc")){
           System.out.println("abc is present");
       }else{
           System.out.println("abc is not present");
       }
       if(album2.findSong("Doorie")){
           System.out.println("Doorie is present");
       }else{
           System.out.println("Doorie is not present");
       }

        //create playlist
        LinkedList<Song> myPlayList = new LinkedList<>();
        album1.AddToPlaylistFromAlbum("Srivalli",myPlayList);
        album2.AddToPlaylistFromAlbum(2,myPlayList);
        album1.AddToPlaylistFromAlbum(1,myPlayList);

        // wrong song
        album1.AddToPlaylistFromAlbum(5,myPlayList);
        album2.AddToPlaylistFromAlbum("random",myPlayList);

        play(myPlayList);
    }

    public static void play(LinkedList<Song> playlist){
        ListIterator<Song> itr = playlist.listIterator();

        if(!itr.hasNext()){
            System.out.println("Your playlist is empty");
            return;
        }
            System.out.println("Now playing..");
            System.out.println(itr.next());

            boolean wasNext = true;
            printMenu();

            Scanner sc = new Scanner(System.in);


            while(true){
                System.out.println("Please enter your option");
                int option = sc.nextInt();
                switch(option){
                    case 1:
                        if(wasNext==false){
                            itr.next();
                            wasNext = true;
                        }
                        if(itr.hasNext()){
                            System.out.println("Now playing: ");
                            System.out.println(itr.next());
                            wasNext = true;
                        }
                        else{
                            System.out.println("You have reached the end of the playlist");
                        }
                        break;
                    case 2:
                        if(wasNext==true){
                            itr.previous();
                            wasNext = false;
                        }
                        if(itr.hasPrevious()){
                            System.out.println("Now playing: ");
                            System.out.println(itr.previous());
                            wasNext = false;
                        }
                        else{
                            System.out.println("You are at the starting of the playlist");
                        }
                        break;
                    case 3:
                        if(wasNext==true){
                            if(itr.hasPrevious()){
                                System.out.println("Now playing: ");
                                System.out.println(itr.previous());
                                wasNext = false;
                            }
                        }
                        else{
                            if(itr.hasNext()){
                                System.out.println("Now playing: ");
                                System.out.println(itr.next());
                                wasNext = true;
                            }
                        }
                        break;
                    case 4:
                        printSongs(playlist);
                        break;
                    case 5:
//                        if(wasNext==true){
//                            if(itr.hasPrevious()){
//                                itr.remove();
//                                System.out.println("delete the current song ");
//                                System.out.println(itr.previous());
//                                wasNext = false;
//                            }
//                        }
//                        else{
//                            if(itr.hasNext()){
//                                itr.remove();
//                                System.out.println("delete the current song ");
//                                System.out.println(itr.next());
//                                wasNext = true;
//                            }
//                        }
                        break;
                    case 6:
                        printMenu();
                        break;
                    case 7:
                        exit(0);
                 }
              }
          }
        public static void printSongs(LinkedList<Song> playlist){
            for(Song s: playlist){
                System.out.println(s);
            }
            return;
        }
        public static void printMenu(){

            System.out.println("1. Play next song");
            System.out.println("2. Play previous song");
            System.out.println("3. Repeat the current song");
            System.out.println("4. Show all songs in playlist");
            System.out.println("5. delete the current song");
            System.out.println("6. Show the menu again");
            System.out.println("7. Exit");
        }
}