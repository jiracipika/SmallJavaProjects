/*
<COSC 2007>
<Rajin Santos Gajadhar>
<239479650> 
<Assignment 4>
*/

class ShortestPath{
  
   static final int MAX = 10;
   static final int INFINITY= 9999;  
      
  void algodijkstra(int graph[][], int vertices, int startnode) {
    
     int cost[][] = new int[MAX][MAX];
     
     int distance[] = new int[MAX];
     int pred[] = new int[MAX];

    int visited[] = new int[MAX];
    int count,mindistance,nextnode =0 ,i,j;
    
    //count gives the number of nodes seen so far

    //create the cost matrix

    for(i=0;i<vertices;i++)
       
       for(j=0;j<vertices;j++)
       { 
           if(graph[i][j]==0)

                cost[i][j]=INFINITY;

            else

                cost[i][j]=graph[i][j];
           
       }
       
    //initialize pred[], distance[] and visited[]

    for(i=0;i<vertices;i++)

    {

        distance[i]=cost[startnode][i];

        pred[i]=startnode;

        visited[i]=0;

    }

    distance[startnode]=0;

    visited[startnode]=1;

    count=1;

    while(count<vertices-1)

    {

       mindistance=INFINITY;

      //nextnode gives the node at minimum distance

     for(i=0;i<vertices;i++)

      if(distance[i]<mindistance && (visited[i]==0) ) 

      {

           mindistance=distance[i];

           nextnode=i;

      }

      //check if a better path exists through nextnode

      visited[nextnode]=1;

      for(i=0;i<vertices;i++)

       if(visited[i] == 0)

         if(mindistance+cost[nextnode][i]<distance[i])

         {

             distance[i]=mindistance+cost[nextnode][i];

             pred[i]=nextnode;

          }

     count++;

    }

    //print the path and distance of each node

    for(i=0;i<vertices;i++)

       if(i!=startnode)

    {

      System.out.printf("\n  Distance of node%d=%d",i,distance[i]);

      System.out.printf("\n Path=%d",i);

      j=i;

     do

     {

        j=pred[j];

        System.out.printf("<-%d",j);

      }while(j!=startnode);

      }


    
  }  
    
}


class Main{
    public static void main(String[] args) 
    { 
       
        int graph[][] = new int[][] { { 0, 4, 2, 0, 0}, 
                                      { 0, 0, 3, 2, 3}, 
                                      { 0, 1, 0, 4, 5}, 
                                      { 0, 0, 0, 0, 0}, 
                                      { 0, 0, 0, 1, 0} 
                                                        }; 

                         
        ShortestPath g = new ShortestPath(); 
        g.algodijkstra(graph, 5, 0);  // 0 represents the starting node and 5 represents number of vertices
    } 
}