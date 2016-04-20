public class OddEvenSort {
	static int[] arr;
	
	public static int[] sort()
	{
		//Step 1: Initialize Variables
		int i, j, k;
		
		//Step 2: Pass values to threads
		for(k = 0 ; k < arr.length ; k++)
		{
			if(k%2==0)
			{	int count;
				//Step 3: Create a threadpool
				ThreadPool[] thpool1 = new ThreadPool[arr.length/2];
				
				for(i = 0,count = 0; i < arr.length ; i += 2,count++)
				{
					if(i!=arr.length-1){
						//Step 4: Start the thread
						ThreadPool th = new ThreadPool(i, i+1,count);
						thpool1[count] = th;
						thpool1[count].start();

					}
				}
				for(int p=0;p<thpool1.length;p++){
					try {
						//Step 5: Join the threads 
						thpool1[p].join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			else
			{
				int count;
				ThreadPool[] thpool2;
				if(arr.length%2 == 0){
					thpool2 = new ThreadPool[(arr.length/2) -1];
				}else{
					thpool2 = new ThreadPool[arr.length/2];
				}
				for(j = 1,count =0 ; j < arr.length ; j += 2,count++)
				{
					if(j!=arr.length-1){
						ThreadPool th = new ThreadPool(j, j+1,(arr.length/2)+count);
						thpool2[count] = th;
						thpool2[count].start();
					}
				}
				for(int p=0;p<thpool2.length;p++){
					try {
						thpool2[p].join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return arr;	
	}
}

class ThreadPool extends Thread{
	int lo,hi,threadID;
	public ThreadPool(int lo, int hi, int threadID) {
		this.lo = lo;
		this.hi = hi;
		this.threadID = threadID;
	}
	public void run() {
		if(OddEvenSort.arr[lo]>OddEvenSort.arr[hi])
		{	
			//Swap
			OddEvenSort.arr[lo] = OddEvenSort.arr[lo] + OddEvenSort.arr[hi];
			OddEvenSort.arr[hi] = OddEvenSort.arr[lo] - OddEvenSort.arr[hi];
			OddEvenSort.arr[lo] = OddEvenSort.arr[lo] - OddEvenSort.arr[hi];
		}
		System.out.println("Thread no:"+ threadID);
	}
}
