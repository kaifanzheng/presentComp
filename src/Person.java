
public class Person {
    private int mBirth;
    private int mDeath;

    public Person(int birth, int death) {
        if (death < birth) {
            throw new IllegalArgumentException("wrong input");
        }
        this.mBirth = birth;
        this.mDeath = death;
    }

    public int getBirthYear() {
        return this.mBirth;
    }

    public int getDeathYear() {
        return this.mDeath;
    }
    public boolean isAlive(int year){
        
        if(year<this.mBirth || year>this.mDeath){
            return false;
        }else{
            return true;
        }
    }
}
