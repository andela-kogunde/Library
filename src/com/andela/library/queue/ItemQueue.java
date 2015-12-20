package com.andela.library.queue;


import com.andela.library.collections.CollectionsInterface;
import com.andela.library.model.Item;
import com.andela.library.model.Member;

import java.util.ArrayList;
import java.util.Collection;
import java.util.PriorityQueue;

public abstract class ItemQueue<B extends Item, M extends Member> implements CollectionsInterface<B, M> {

    private ArrayList<B> itemList;
    private PriorityQueue<M> memberList;

    private int itemCounter;
    private int memberCounter;

    public ItemQueue(){
        itemList = new ArrayList<>();
        memberList = new PriorityQueue<>();
    }

    @Override
    public void addItem(B item) {
        item.setId(itemCounter);
        itemList.add(item);
        itemCounter++;
    }

    @Override
    public void addAllItems(Collection<B> items) {
        for (B item : items){
            addItem(item);
        }
    }

    @Override
    public B getItem(int index) {
        return itemList.get(index);
    }

    @Override
    public Collection<B> getAllItems() {
        return itemList;
    }

    @Override
    public void removeItem(B item) {
        itemList.remove(item);
    }

    @Override
    public void removeItem(int index) {
        itemList.remove(index);
    }

    @Override
    public void removeAllItems(Collection<Integer> indexes) {
        for (int index : indexes){
            removeItem(index);
        }
    }

    @Override
    public int itemSize() {
        return itemList.size();
    }

    @Override
    public void clearItems() {
        itemList.clear();
    }

    @Override
    public void addMember(M member) {
        member.setId(memberCounter);
        memberList.add(member);
        memberCounter++;
    }

    @Override
    public void addAllMembers(Collection<M> members) {
        for (M member : members){
            addMember(member);
        }
    }

    public M getNextMember() {
        return memberList.poll();
    }

    @Override
    public Collection<M> getAllMembers() {
        return memberList;
    }

    @Override
    public void removeMember(M member) {
        memberList.remove(member);
    }

    @Override
    public void removeAllMembers(Collection<M> members) {
        for (M member : members){
            removeMember(member);
        }
    }

    @Override
    public int memberSize() {
        return memberList.size();
    }

    @Override
    public void clearMembers() {
        memberList.clear();
    }
}
