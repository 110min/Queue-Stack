/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackapp;

/**
 *
 * @author 174110j
 */
public class StackApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        // TODO code application logic here
        StackArray s1 = new StackArray(6);
//        s1.push(4);
//        s1.push(5);
//        s1.push(6);
//        s1.push(10);
//        s1.push(40);
//        s1.push(4);
//        s1.display();
        try{
            s1.pop();
        }catch(Exception e){
            System.out.println(e);
        }
        s1.display();
        
        try{
            s1.peek();
        }catch(Exception e){
            System.out.println(e);
        }
        s1.display();
    }
    
}

class StackArray{
    private int maxSize; //size of stack array
    private int [] stackData;
    private int top; //top of stack
    
    public StackArray (int s) //constractor 
    {
        this.stackData = new int[s];
        this.maxSize = s;
        this.top = -1;
    } 
    
    
    
    public boolean isEmpty () //true if stack is empty
    {
        return top == -1; //top 1 -1 weddi true kiyala return wenawa(if else 1k dannath puluwan)
    } 
    
    
    
    public boolean isFull () 
    {
        return this.top == this.maxSize-1;  //if else 1k dannath puluwan
    }
    
    
    
    public void push (int j) //put item on top of the stack
    {
        if(isFull()){
            System.out.println("stack is full can not push");
            return;
        }
        this.stackData[++top] = j; //pre increment top index 1 1kin wedi karala ekata j danawa 2nd line 1 ona nehe
        //this.top++;
    } 
    
    public int pop () throws Exception //take item from top of the stack
    {
       if(isEmpty()){
            //System.out.println("stack is empty can not pop");
            //return -1;  //-1 kiyala value 1k thibunoth meka confuse wenawa eka nisa exception 1k denna ona(can't return a value), generate your own exception
            throw new Exception("stack is empty can not pop");
       }
       //top--;
       return this.stackData[top--];    //postdecrement
    } 
    
    
    public int peek ()throws Exception //peek at top of the stack
    {
        if(isEmpty()){
            throw new Exception("stack is empty there is no peak");
       }
        return this.stackData[top];
    } 
    
    public void display()
    {
        for(int i=top;i>=0;i--){
            System.out.print(stackData[i]+" ");
        }
        System.out.println();
    }
}
