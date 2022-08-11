package week02;

public class Taxi extends Transport{
    String destination;
    int distance;
    int distance_init = 1;
    int pay_init = 3000;
    int pay_add = 1000;
    int pay;
    int pay_total=0;

    public Taxi(){
        num = (int)(Math.random()*10000+1);
        System.out.println("taxi:" +this.num);
        max_passenger = 4;
        board_passenger = 0;
    }
    void print_taxi(){
        System.out.println("탑승 승객 수 :" +board_passenger);
        System.out.println("잔여 승객 수 :" +max_passenger);
        System.out.println("기본 요금 확인 :" +pay_init);
        System.out.println("목적지 :" +destination);
        System.out.println("목적지까지 거리 :" +distance +"km");
        System.out.println("지불할 요금 :" +pay);
        if(state()==true){
            System.out.println("상태 :  운행중" );
        }
    }
    public void board(String des, int dis, int passenger){
        if(passenger>max_passenger){
            System.out.println("최대 승객 수 초과");
        }else{
            destination= des;
            distance = dis;
            board_passenger += passenger;
            max_passenger -= passenger;
            pay = (dis-distance_init)*pay_add +pay_init;
        }
    }
    public void refuel(int l){
        super.refuel(l);
        if(state() == false){
            System.out.println("상태: 운행불가");
        }
    }
    public void taxi_payment(){
        board_passenger=0;
        max_passenger=4;
        pay_total += pay;
        pay =0;

        System.out.println("누적 요금 :" +pay_total);
    }
    public static void main(String[] args){
        Taxi taxi = new Taxi();
        Taxi taxi2 = new Taxi();

        taxi.board("서울역",2,2);
        taxi.print_taxi();
        taxi.refuel(-80);

        taxi.taxi_payment();

        taxi.board("구로디지털단지역",12,5);

        taxi.board("구로디지털단지역",12,3);
        taxi.print_taxi();

        taxi.refuel(-20);
        taxi.taxi_payment();
    }
}
