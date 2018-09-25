package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MixingMilk {

    private static class MilkCompany implements Comparable<MilkCompany> {
        int pay = 0;
        int tot = 0;

        @Override
        public int compareTo(MilkCompany o) {
            return this.pay - o.pay;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int remainMilk = Integer.parseInt(st.nextToken());
        int paySum = 0;
        int cnt = Integer.parseInt(st.nextToken());
        MilkCompany[] companies = new MilkCompany[cnt];

        for(int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            MilkCompany company = new MilkCompany();
            company.pay = Integer.parseInt(st.nextToken());
            company.tot = Integer.parseInt(st.nextToken());
            companies[i] = company;
        }

        Arrays.sort(companies);

        for(int i = 0; (i < cnt) && remainMilk != 0; i++) {
            if(remainMilk >= companies[i].tot) {
                remainMilk -= companies[i].tot;
                paySum += companies[i].pay * companies[i].tot;
            }
            else {
                paySum += remainMilk * companies[i].pay;
                break;
            }
        }
        System.out.println(paySum);



    }
}
