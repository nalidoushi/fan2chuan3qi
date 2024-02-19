package exec.domain;

public class Score {
    private int id;
    private int math;
    private int chinese;
    private int english;
    private int uid;

    public Score() {
    }

    public Score(int id, int math, int chinese, int english, int uid) {
        this.id = id;
        this.math = math;
        this.chinese = chinese;
        this.english = english;
        this.uid = uid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getChinese() {
        return chinese;
    }

    public void setChinese(int chinese) {
        this.chinese = chinese;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "[" +
                "id：" + id +
                ", 学号：" + uid +
                ", 数学：" + math +
                ", 语文：" + chinese +
                ", 英语：" + english +
                ", 总分：" + (math+chinese+english) +
                ']';
    }
}
