package day_05;

import java.util.ArrayList;
import java.util.Objects;

public class UpdateLogic {
    ArrayList<Rule> pageRules;
    ArrayList<UpdateList> updateLists;

    public UpdateLogic(ArrayList<String> ruleList, ArrayList<String> updateList) {
        CreateRules(ruleList);
        CreteUpdates(updateList);
    }

    public void CreteUpdates(ArrayList<String> updateList) {
        this.updateLists = new ArrayList<>();
        for(String line : updateList) {
            updateLists.add(new UpdateList(line));
        }

//        printUpdates();
    }


    public void findMiddleNumber() {
        int sum = 0;
        for(UpdateList updateList : updateLists) {
            if(updateList.isOrderRight) {
                sum+=updateList.updates.get(updateList.updates.size()/2);
            }
        }
        System.out.println(sum);
    }

    public void CheckAllOrder() {
        for (UpdateList updateList : updateLists) {
            updateList.isOrderRight = CheckOrder(updateList);
//            System.out.println(updateList.isOrderRight);
        }
    }

    public boolean CheckOrder(UpdateList list) {
        for(int j = 0; j < list.updates.size(); j++) {
            Rule rule = findRule(list.updates.get(j));
            if(rule == null) {
                System.out.println("Null rule!");
            } else {
                for(int prev = 0; prev < j; prev++) {
                    for(Integer n : rule.nextNumbers) {
                        if(Objects.equals(list.updates.get(prev), n)) {
                            return false;
                        }
                    }
                }
                for(int next = j + 1; next < list.updates.size(); next++) {
                    for(Integer p : rule.previousNumbers) {
                        if(Objects.equals(list.updates.get(next), p)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public void CreateRules(ArrayList<String> rulesList) {
        this.pageRules = new ArrayList<>();

        for(String line : rulesList) {
            String[] split = line.split("\\|");
            if(isRule(Integer.parseInt(split[0]))) {
                // when rule exists, only add next:
                findRule(Integer.parseInt(split[0])).AddNext(Integer.parseInt(split[1]));
                if(!isRule(Integer.parseInt(split[1]))) {
                    Rule rule1 = new Rule(Integer.parseInt(split[1]));
                    rule1.AddPrevious(Integer.parseInt(split[0]));
                    AddNewRule(rule1);
                }

            }
            if (isRule(Integer.parseInt(split[1]))) {
                // when rule exists, only add previous:
                findRule(Integer.parseInt(split[1])).AddPrevious(Integer.parseInt(split[0]));
                if(!isRule(Integer.parseInt(split[0]))) {
                    Rule rule1 = new Rule(Integer.parseInt(split[0]));
                    rule1.AddNext(Integer.parseInt(split[1]));
                    AddNewRule(rule1);
                }
            }
            if(!isRule(Integer.parseInt(split[0])) && !isRule(Integer.parseInt(split[1]))) {
                // rule does not exist
                Rule rule1 = new Rule(Integer.parseInt(split[0]));
                rule1.AddNext(Integer.parseInt(split[1]));

                Rule rule2 = new Rule(Integer.parseInt(split[1]));
                rule2.AddPrevious(Integer.parseInt(split[0]));

                AddNewRule(rule1);
                AddNewRule(rule2);
            }
        }

//        printRules();
    }

    public void AddNewRule(Rule rule) {
        pageRules.add(rule);
    }

    public Rule findRule(int pageNumber) {
        for(Rule r : pageRules) {
            if(r.pageNumber == pageNumber) {
                return r;
            }
        }
        return null;
    }

    public boolean isRule(int page) {
        for(Rule r : pageRules) {
            if(r.pageNumber == page) {
                return true;
            }
        }
        return false;
    }

    public void printRules() {
        for(Rule r : pageRules) {
            System.out.println("page: " + r.pageNumber);
            System.out.println("previous pages: " + r.previousNumbers);
            System.out.println("next pages: " + r.nextNumbers);
        }
    }

    public void printUpdates() {
        for(UpdateList u : updateLists) {
            for(Integer i : u.updates) {
                System.out.print(i + ", ");
            }
            System.out.println();
        }
    }

    public void printRightOrder() {
        for(UpdateList ul : updateLists) {
            if(ul.isOrderRight) {
                for(Integer i : ul.updates) {
                    System.out.print(i + ", ");
                }
                System.out.println();
            }
        }
    }

    public void printOrder() {
        for(UpdateList ul : updateLists) {
            System.out.println(ul.isOrderRight);
        }
    }

}
