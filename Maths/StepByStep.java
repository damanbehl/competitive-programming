package Maths;

//https://www.interviewbit.com/problems/step-by-step
public class StepByStep {
    // // will fail cannot be O(n)
    // public int solve(int A) {
    // //Negative value is flip of positive value
    // A = Math.abs(A);
    // int i = 0;
    // int running_sum = 0;
    // while(running_sum<A){
    // i+=1;
    // running_sum +=i;
    // }
    // // value to be removed has to be even
    // //because to remove y from running sum we have to
    // // remove y/2 from sequence
    // // int overFlow = running_sum-A;
    // while((running_sum-A)%2!=0){
    // i+=1;
    // running_sum+=i;
    // }
    // return i;
    // }
    // (-b+(b^2-4ac)^1/2)/2a
    public int solve(int A) {
        A = Math.abs(A);
        int i = ((int) (Math.sqrt(1 + 8 * A) - 1)) / 2;
        int running_sum = (i * (i + 1)) / 2;
        while (running_sum < A || (running_sum - A) % 2 != 0) {
            i += 1;
            running_sum += i;
        }
        return i;
    }
}
