package jp.ac.uryukyu.ie.e165752;

/**
 * ヒーロークラス。
 *  Created by komineakina on 2016/12/28.
 */
public class Hero extends LivingThing{

    public Hero (String name, int maximumHP, int attack) {

        super(name,maximumHP,attack);

    }

    @Override
    public void attack(LivingThing opponent){
        int damage = 0;
        if (isDead() == false) {
            damage = (int) (Math.random() * getAttack());

            //クリティカルヒット
            if (damage >= 1 && (Math.random() *100) <= 29){
                damage = damage * 2; //ダメージ二倍
                System.out.printf("%sの攻撃！会心の一撃！！%sに%dのダメージを与えた！！\n",super.getName(),opponent.getName(),damage);

            } else if (damage == 0){
                System.out.printf("%sの攻撃！,,,だが、%sは攻撃を回避した！\n",super.getName(), opponent.getName());

            }else {
                System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", super.getName(), opponent.getName(), damage);
            }
        }
        opponent.wounded(damage);
    }

}