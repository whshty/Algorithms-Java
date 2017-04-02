// Teng Yang txy188

#include <stdio.h>
#include <stdlib.h>
#include <omp.h>
#include <sys/time.h>


 
void merge(int* a, int* tmp, int left, int mid, int right);
void msort(int* a, int* tmp, int left, int right);
void display(int* a,const int size);
 
int main(int argc, char * argv []) {
    int N = atoi(argv[1]);
	int* a = malloc(sizeof(int) * N);
	int* tmp = malloc(sizeof(int) * N);
	int i;
    for (i = 0; i < N; i++)
		a[i] = N - i;

    if ( N == 16 ){
       printf("Array before sorting:\n");
       display(a,N); 
    }

    
    
    struct timeval start_time, stop_time, elapsed_time; 
    gettimeofday(&start_time,NULL);
    msort(a, tmp, 0, N - 1);
    
    if ( N == 16 ){
      printf("Array after sorting:\n");
      display(a,N);  
    }
    
    gettimeofday(&stop_time,NULL);
    timersub(&stop_time, &start_time, &elapsed_time); 
    printf("%f \n", elapsed_time.tv_sec+elapsed_time.tv_usec/1000000.0);


	free(a);
	free(tmp);
    return 0;
}


void msort(int* a, int* tmp, int left, int right) {
    
    static int isFisrtLevel = 1;
    int mid;
    if (right > left) {
        if( isFisrtLevel){
            int nthreads, tid;
            //omp_set_num_threads(4);
            #pragma omp parallel private(tid) 
            {   
                tid = omp_get_thread_num(); 
                nthreads = omp_get_num_threads();
                //printf("%d threads in total \n", nthreads);
                //printf("This is the %dth thread \n", tid);
                int Start = tid * (1 + right - left) / nthreads;
                int End = (tid+1) * (1 + right - left ) /nthreads -1 ;

                isFisrtLevel = 0;
                msort(a, tmp, Start, End);
            }
            int i;
            for( i = 0 ; i < nthreads -1 ; i++ ){
                int len = (1 + right - left) / nthreads;
                int mid = (i+1) * len;
                merge(a,tmp,0,mid,mid+len-1);
            }

        } else {
            mid = (right + left) / 2;
            msort(a, tmp, left, mid);
            msort(a, tmp, mid + 1, right);
            merge(a, tmp, left, mid + 1, right);
        }
    }

}

 
// Merge two subarrays
void merge(int* a, int* tmp, int left, int mid, int right) {
    int i, left_end, count, tmp_pos;
    left_end = mid - 1;
    tmp_pos = left;
    count = right - left + 1;
 
	// Main merge
    while ((left <= left_end) && (mid <= right)) {
        if (a[left] <= a[mid]) {
            tmp[tmp_pos] = a[left];
            tmp_pos++;
            left++;
        } else {
            tmp[tmp_pos] = a[mid];
            tmp_pos++;
            mid++;
        }
    }
 
	// Copy remainder of left
    while (left <= left_end) {
        tmp[tmp_pos] = a[left];
        left++;
        tmp_pos++;
    }

	// Copy remainder of right
    while (mid <= right) {
        tmp[tmp_pos] = a[mid];
        mid++;
        tmp_pos++;
    }
 
	// Copy temp array back to original
    for (i = 0; i < count; i++) {
        a[right] = tmp[right];
        right--;
    }
}

// Utility for printing
void display(int* a, const int size) {
    int i;
    for(i = 0; i < size; i++)
        printf("%d ",a[i]);
 
    printf("\n");
}