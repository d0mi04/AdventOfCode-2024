package day_09;

import shared.OneLineInput;

import java.util.Collections;
import java.util.Objects;

public class FileSystem {
    DiscMap discMap;

    public FileSystem(OneLineInput line) {
        this.discMap = new DiscMap();
        for(int i = 0; i < line.getData().size(); i++) {
            discMap.addNextBlock(i, line.getData().get(i));
        }
    }

    public void CountChecksum() {
        int checksum = 0;
        for(int i = 0; i < discMap.getFileBlock().size(); i++) {
            if(Objects.equals(discMap.getFileBlock().get(i), ".")) {
                break;
            } else {
                checksum += i * Integer.parseInt(discMap.getFileBlock().get(i));
            }
        }
        System.out.println(checksum);
    }

    public void RemoveGaps() {
        for(int i = 0; i < discMap.getFileBlock().size(); i++) {
            if(Objects.equals(discMap.getFileBlock().get(i), ".")) {
                for(int j = discMap.getFileBlock().size() - 1; j > i; j--) {
                    if(!Objects.equals(discMap.getFileBlock().get(j), ".")) {
                        Collections.swap(discMap.getFileBlock(), j, i);
                        break;
                    }
                }
            }
        }
    }

    public void printFileSystem() {
        for(String s : discMap.getFileBlock()) {
            System.out.print(s);
        }
        System.out.println();
    }
}
