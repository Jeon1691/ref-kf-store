package com.kakaofriends.front.domain;

import com.kakaofriends.core.domain.Product;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Dave on 2017. 4. 25..
 */
@Data
public class BoxItem implements Comparable<BoxItem> {
    private int boxName;
    private String itemName;
    private ArrayList<Double> size;
    private ArrayList<BoxItem> itemList;
    private long weight = 0;
    private int seq;
    private double amount;
    private double exchangeAmount;
    private int ea = 1;
    private String productCode;
    private String orderPk; // 박스일땐 order main pk 아이템일땐 order sub pk
    private String boxPk;

    public BoxItem(){};

    public BoxItem(double x, double y, double z, long weight) {
        this.size = new ArrayList<>();
        this.size.add(x);
        this.size.add(y);
        this.size.add(z);
        Collections.sort(size);
        Collections.reverse(size);
        this.weight = weight;
    }

    public BoxItem(Product product,long amount, String orderPk) {
        this.size = new ArrayList<>();
        this.size.add(product.getPrDepth());
        this.size.add(product.getPrHeight());
        this.size.add(product.getPrWidth());
        Collections.sort(size);
        Collections.reverse(size);
        this.productCode = product.getPrCode();
        this.orderPk = orderPk;
        this.weight = (long) product.getPrWeight();
        this.amount = amount;
        this.itemName = product.getPrName();
        boxName = -1;
    }

    public BoxItem(Product product, double amount, String orderPk, String language) {
        this.size = new ArrayList<>();
        this.size.add(product.getPrDepth());
        this.size.add(product.getPrHeight());
        this.size.add(product.getPrWidth());
        Collections.sort(size);
        Collections.reverse(size);
        this.productCode = product.getPrCode();
        this.orderPk = orderPk;
        this.weight = (long) product.getPrWeight();
        this.amount = amount;
        if (language.toLowerCase().equals("kr"))
            this.itemName = product.getPrName();
        else
            this.itemName = product.getPrName1();
        boxName = -1;
    }

    public BoxItem(com.kakaofriends.front.service.product.vo.Product product, double amount, String orderPk) {
        this.size = new ArrayList<>();
        this.size.add(product.getDepth());
        this.size.add(product.getHeight());
        this.size.add(product.getWidth());
        Collections.sort(size);
        Collections.reverse(size);
        this.productCode = product.getProductCode();
        this.orderPk = orderPk;
        this.weight = product.getWeight().longValue();
        this.amount = amount;
        this.itemName = product.getEnglishName();
        boxName = -1;
    }

    public BoxItem(BoxItem boxItem, String boxName, int seq, String orderPk) {
        this.size = new ArrayList<>(boxItem.getSize());
        this.weight = boxItem.getWeight();
        this.seq = seq;
        this.orderPk = orderPk;
        this.boxName = Integer.valueOf(boxName);
    }

    public BoxItem(String boxPk, String productCode, double amount){
        this.boxPk = boxPk;
        this.productCode = productCode;
        this.amount = amount;
    }

    public double getVolume() {
        double volume = 1;
        for (Double i : size) {
            volume *= i;
        }
        return volume;
    }

    @Override
    public int compareTo(BoxItem boxItem) {
        // volume이 작은 순으로 정렬
        // 기존.. 무게도 계산에 넣기 위해서 수정. 2018.02.01 Breeze
        // return (int) Math.round(this.getVolume() - boxItem.getVolume());
        return (int) Math.round((this.getVolume() + this.weight) - (boxItem.getVolume() + boxItem.getWeight()));
    }


    public boolean isInsertPossible(BoxItem orgBox, double totVolume, double maxItemSize) {
        if(totVolume == 0)
            return false;

        // item insert 이후 부피 구하기
        //double afterInsertVolume = this.getVolume() - item.getVolume();
        double afterInsertVolume = this.getVolume() - totVolume;

        //item 별 최대 길이 값 받아 가능 여부 체크
        boolean sizeCheck = (orgBox.getSize().get(0) > maxItemSize);

        // 박스에 남은 부피가 기존 박스 부피의 5%보다 많이 남았는지 체크 (박스에는 80%까지만 담겨야 함으로)
        // 박스에 적재 가능 한 최대 부피 95%로 변경 (5/30 정기회의에서 요청)
        // 2017.12.22 회의에서 박스 용적률 85%로 변경. Breeze
        boolean volumeCheck = (orgBox.getVolume() * 0.15) <= afterInsertVolume;

        return volumeCheck && sizeCheck;
    }

    public void sort() {
        Collections.sort(size);
        Collections.reverse(size);
    }

    public void insertBox(BoxItem item) {
        this.weight += item.getWeight();
        this.amount += item.getAmount();
        this.addItemList(item);
    }

    // 같은 아이템이 이미 있다면 ea(수량) 만 + 1
    public void addItemList(BoxItem item){
        if(itemList == null){
            itemList = new ArrayList<>();
        }

        for(int i=0; i<itemList.size(); i++){
            if(itemList.get(i).getProductCode().equals(item.getProductCode())){
                itemList.get(i).setEa(itemList.get(i).getEa()+1);
                return;
            }
        }
        item.setSeq(this.itemList.size() + 1);
        this.itemList.add(item);
    }

    // 가격 = 가격 * 수량
    public double getAmount(){
        return this.amount * this.ea;
    }

}
