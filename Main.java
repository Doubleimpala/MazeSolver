import java.util.Scanner;
import java.io.*;


class Main {
  public static void main(String[] args) throws Exception {
    Stack postack = new Stack();
    Stack dir = new Stack();
    Stack solution = new Stack();
    Scanner file = new Scanner(new File("maze.txt"));
    char[][] maze1;

    int rows = 0;
    int cols = 0;
    
    while(file.hasNext()){
      String line = file.next();
      rows++;
      cols = line.length();
    }
    
    maze1 = new char[rows+2][cols+2];
    
    file = new Scanner(new File("maze.txt"));

    for(int sjd = 0; sjd < rows+2; sjd++){
      for(int hdd = 0; hdd < cols+2; hdd++){
        maze1[sjd][hdd] = '#';
      }
    }
    

    for(int r = 1; r < rows+1; r++){
      String thisRow = file.next();
      for(int c =1; c < cols; c++){
        maze1[r][c] = thisRow.charAt(c);
      }
    }

    int posx = 0;
    int posy = 0;
    char symbol;

    for(int q = 0; q< rows+2; q++){
      for(int w = 0; w < cols+2; w++){
        if(maze1[q][w] == '@'){
          posx = q;
          posy = w;
          postack.push("("+posx+","+posy+")");
        }
      }
    }

    for(int e = 0; e< rows+2; e++){
      System.out.println("");
      for(int t = 0; t < cols+2; t++){
        System.out.print(maze1[e][t]);
      }
    }
    dir.push("start");

    while(maze1[posx][posy] != '$'){
      if(maze1[posx -1][posy] == '.'){
        maze1[posx][posy] = '#';
        posx--;
        
        System.out.println(maze1[posx][posy] );
        postack.push("("+posx+","+posy+")");
        dir.push("left");
      } else if(maze1[posx+1][posy] == '.'){
        maze1[posx][posy] = '#';
        posx++;
        
        postack.push("("+posx+","+posy+")");
        dir.push("right");
      } else if(maze1[posx][posy-1] == '.'){
        maze1[posx][posy] = '#';
        posy--;
        
        postack.push("("+posx+","+posy+")");
        dir.push("down");
      } else if(maze1[posx][posy+1] == '.'){
        maze1[posx][posy] = '#';
        posy++;
        
        postack.push("("+posx+","+posy+")");
        dir.push("up");
      } else if(maze1[posx+1][posy] == '$'){
        posx++;
        postack.push("("+posx+","+posy+")");
        break;
      } else if(maze1[posx-1][posy] == '$'){
        posx--;
        postack.push("("+posx+","+posy+")");
        break;
      } else if(maze1[posx][posy+1] == '$'){
        posy++;
        postack.push("("+posx+","+posy+")");
        break;
      } else if(maze1[posx][posy-1] == '$'){
        posy--;
        postack.push("("+posx+","+posy+")");
        break;
      } else if(maze1[posx+1][posy] == '#' && maze1[posx-1][posy] == '#' && maze1[posx][posy+1] == '#' && maze1[posx][posy-1] == '#'){
        if(dir.peek().equals("left")){
          maze1[posx][posy] = '#';
          dir.pop();
          posx++;
        } else if(dir.peek().equals("right")){
          maze1[posx][posy] = '#';
          dir.pop();
          posx--;
        } else if(dir.peek().equals("up")){
          maze1[posx][posy] = '#';
          dir.pop();
          posy--;
        } else if(dir.peek().equals("down")){
          maze1[posx][posy] = '#';
          dir.pop();
          posy++;
        } else if(dir.peek().equals("start")){
          System.out.println("Bruhh why");
          for(int yt = 0; yt< rows+2; yt++){
            System.out.println("");
            for(int yr = 0; yr < cols+2; yr++){
              System.out.print(maze1[yt][yr]);
            }
          } 
        } else{
          System.out.println("STOP AA");
        }
        postack.pop();
      } else{
        break;
      }
    }

    
    while(postack.peek() != null){
      solution.push(postack.pop());
    }
    while(solution.peek() != null){
      System.out.println(solution.pop());
    }
    
  }
}