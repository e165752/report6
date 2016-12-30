package jp.ac.uryukyu.ie.e165752;

/**
 * 生物クラス。
 *  String name; //スライム,勇者の名前
 *  int hitPoint; //スライム,勇者のHP
 *  int attack; //スライム,勇者の攻撃力
 *  boolean dead; //スライム,勇者の生死状態。true=死亡。
 *  Created by komineakina on 2016/12/30.
 */
public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name モンスター名,勇者の名前
     * @param maximumHP モンスター,勇者のHP
     * @param attack モンスター,勇者の攻撃力
     */
    public LivingThing (String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    /**
     * getterメソッドと同等。生死をboolean表現しているためメソッド名をisDead()とした。
     * @return boolean
     */

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead){
        this.dead = dead;
    }

    public String getName(){
        return name;
    }

    public int getHitPoint(){
        return hitPoint;
    }

    /**
     * 攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、wounded()によりダメージ処理を実行。
     * @param oppone 攻撃対象
     */

    public void attack(LivingThing oppone){
        int damage = 0;
        if (dead == false) {
            damage = (int) (Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, oppone.getName(), damage);
        }
        oppone.wounded(damage);
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            dead = true;
            System.out.printf("モンスター%sは倒れた。\n", name);
        }
    }

}
