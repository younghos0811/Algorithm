package K_Test.Test1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    private static Map<String, String> idToNameMap = new HashMap<>();
    private static class Cmd {
        String id;
        String cmd;

    }

    public String[] solution(String[] record) {
        String[] answer = {};
        List<Cmd> cmdList = new ArrayList<>();

        for(int i = 0; i < record.length; i++) {
            String[] splits = record[i].split(" ");
            Cmd cmd = new Cmd();
            cmd.cmd = splits[0];
            cmd.id = splits[1];

            if(cmd.cmd.equals("Enter") || cmd.cmd.equals("Change")) {
                idToNameMap.put(cmd.id , splits[2]);
            }

            if(!cmd.cmd.equals("Change"))
                cmdList.add(cmd);
        }

        answer = new String[cmdList.size()];
        for(int i = 0; i < cmdList.size(); i++) {
            String cmd = cmdList.get(i).cmd;
            String id = cmdList.get(i).id;
            String name = idToNameMap.get(id);

            if(cmd.equals("Enter")) {
                answer[i] = name +"님이 들어왔습니다.";
            }
            else if(cmd.equals("Leave")) {
                answer[i] = name +"님이 나갔습니다.";
            }
        }

        return answer;
    }
}