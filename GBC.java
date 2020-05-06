import java.awt.*;
import javax.swing.*;

public class GBC extends GridBagConstraints{
    //��ʼ�����Ͻ�λ��
    public GBC(int gridx, int gridy){
        this.gridx = gridx;
        this.gridy = gridy;
    }

    //��ʼ�����Ͻ�λ�ú���ռ����������
    public GBC(int gridx, int gridy, int gridwidth, int gridheight){
        this.gridx = gridx;
        this.gridy = gridy;
        this.gridwidth = gridwidth;
        this.gridheight = gridheight;
    }

    //���뷽ʽ
    public GBC setAnchor(int anchor){
        this.anchor = anchor;
        return this;
    }

    //�Ƿ����켰���췽��
    public GBC setFill(int fill){
        this.fill = fill;
        return this;
    }

    //x��y�����ϵ�����
    public GBC setWeight(double weightx, double weighty){
        this.weightx = weightx;
        this.weighty = weighty;
        return this;
    }

    //�ⲿ���
    public GBC setInsets(int distance){
        this.insets = new Insets(distance, distance, distance, distance);
        return this;
    }

    //�����
    public GBC setInsets(int top, int left, int bottom, int right){
        this.insets = new Insets(top, left, bottom, right);
        return this;
    }

    //�����
    public GBC setIpad(int ipadx, int ipady) {
        this.ipadx = ipadx;
        this.ipady = ipady;
        return this;
    }

}