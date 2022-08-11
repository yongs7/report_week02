package week02;

public class Transport {
    protected int num;
    protected int oil = 100;
    protected int speed = 0;
    protected int max_passenger=30;
    protected int board_passenger;
    protected boolean change;

    boolean state(){
        if(oil<10){
            return false;
        }else{
            return true;
        }
    }
    public void board(int passenger){
        max_passenger -= passenger;
        board_passenger = passenger;
    }
    public void speed_change(int speed){
        if(state()==true) {
            this.speed += speed;
            System.out.println("스피드: " +this.speed);
        }else{
            System.out.println("주유필요!");
        }
    }

    public void refuel(int l){
        oil += l;
        System.out.println("주유량: " +oil);

        if(state()==false){
            System.out.println("주유필요! ");
        }
    }
}
