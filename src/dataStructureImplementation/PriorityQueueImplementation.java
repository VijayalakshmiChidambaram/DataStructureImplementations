package dataStructureImplementation;
/* Array:
[12,7,10,1,8]
[12], [12,7]
10>7
[12,10,7]
[12,10,7,1]
8>1
[12,10,7,8,1]
8>7
[12,10,8,7,1]

Algo:
[12,7]
if a.size = 0
a[0] = newV // 12
for(i=a.size-1; i>=0; i--) //1-1=0, 2-1 =1, 0
{
if(a[i] > newV) //12>7, 7>10, 12>10
{
a[i+1] = newV //a[1] = 7, a[1] = 10
}
else {
a[i+1] = a[i] // a[2] = 7
}
}

 */
public class PriorityQueueImplementation {
    public static void main(String[] args) {
        PriorityQueueImplementation prior = new PriorityQueueImplementation();
        prior.insertPQ(5);
        prior.deletePQ();
        prior.isFullPQ();
        prior.isEmptyPQ();
        prior.peekPQ();
    }
    int MAX = 5;
    int pqarr[] = new int[MAX];
    int pqSize = pqarr.length;
    public void insertPQ(int newValue) {
        if(pqSize == 0) {
            pqarr[0] = newValue;
        }
        for (int i = pqSize-1; i>=0; i--) {
            if (pqarr[i] > newValue) {
                pqarr[i + 1] = newValue;
            } else {
                pqarr[i + 1] = pqarr[i];
            }
        }
    }

    public int deletePQ() {
       return pqarr[pqSize--];
    }
    public boolean isFullPQ() {
        return pqSize == MAX;
    }
    public boolean isEmptyPQ() {
        return pqSize == 0;
    }
    public int peekPQ() {
        return pqarr[pqSize-1];
    }
}
