package principle.dimit;

public class DimitMain {

    public static void main(String[] args) {
        Star star = new Star("王力宏");
        Company company = new Company("上海娱乐有限公司");
        Fans fans = new Fans("Tony");
        Agent agent = new Agent();
        agent.setStar(star);
        agent.setCompany(company);
        agent.setFans(fans);
        agent.meeting();
        agent.business();
    }

}
