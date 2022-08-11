package week02;

public class Bus extends Transport{
    int current_passenger;
    int pay=1000;

    public Bus(){
        change = true;
        num = (int)(Math.random()*100+1);
        System.out.println("bus:" +this.num);
    }
    void print_bus(){
        System.out.println("탑승 승객 수: " +board_passenger);
        System.out.println("잔여 승객 수:" +max_passenger);
        System.out.println("요금 확인:" +pay * board_passenger);
    }
   public void print_state(String mode){
        if(mode == "차고지행" || state()==false){
            change = false;
            System.out.println("상태: 차고지행");
        }else{
            change = true;
            System.out.println("상태: 운행");
        }
    }
    public void board(int passenger){
        if(change == true) {
            if (passenger > max_passenger) {
                System.out.println("최대 승객 수 초과");
            } else {
                super.board(passenger);
                current_passenger += board_passenger;
            }
        }else{
            System.out.println("운행중이 아닙니다");
        }
    }

    public static void main(String[] args){
        Bus bus = new Bus();
        Bus bus2 = new Bus();

        bus.board(2);
        bus.print_bus();
        bus.refuel(-50);
        bus.print_state("차고지행");
        bus.refuel(10);
        bus.print_state("운행");
        bus.board(45);
        bus.board(5);
        bus.print_bus();
        bus.refuel(-55);
        bus.print_state("운행");
    }
}
