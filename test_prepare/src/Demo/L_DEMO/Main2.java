package Demo.L_DEMO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {

    static int userPostionX = 0;
    static int userPostionY = 0;

    private static class Shop implements Comparable<Shop>{
        int positionX;
        int positionY;
        int distance;
        int couponCnt;
        String name;

        public Shop(int x, int y, String name, int cnt) {
            this.positionX = x;
            this.positionY = y;
            this.couponCnt = cnt;
            this.name = name;
            //(int) Math.sqrt(Math.pow((user.x-x), 2) + Math.pow((user.y-y), 2))
            distance =  (int)Math.sqrt(Math.pow(userPostionX -x ,2) + (Math.pow(userPostionY -y ,2)));
            distance /= 100;
        }


        @Override
        public int compareTo(Shop o) {
            if(this.distance > o.distance) {
                return 1;
            }
            else if (this.distance < o.distance) {
                return -1;
            }
            else {
                if(this.couponCnt < o.couponCnt)
                    return 1;
                else if (this.couponCnt > o.couponCnt)
                    return -1;
                else {
                    return name.compareTo(o.name);
                }
            }

        }

        private int getNameDiff(char[] objectShopName) {
            char[] thisArr = this.name.toCharArray();

            for(int i = 0; i < 6; i++) {
                int thisNum = (int)thisArr[i] <= 57 ? 100+ (int)thisArr[i] : (int)thisArr[i];
                int diffNum = (int)objectShopName[i] <= 57 ? 100+ (int)objectShopName[i] : (int)objectShopName[i];

                if(thisNum > diffNum)
                    return -1;
                else if(thisNum < diffNum)
                    return 1;
            }

            return 0;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        userPostionX = Integer.parseInt(st.nextToken());
        userPostionY = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());
        Shop[] shops = new Shop[cnt];

        for(int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            Shop shop = new Shop(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()), st.nextToken(),Integer.parseInt(st.nextToken()));
            shops[i] = shop;
        }

        Arrays.sort(shops);

        String result = "";
        for(Shop shop : shops) {
            result += shop.positionX + " ";
            result += shop.positionY + " ";
            result += shop.name + " ";
            result += shop.couponCnt + "\n";
        }

        System.out.println(result);

    }
}
