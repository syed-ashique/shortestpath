package com.syed.shortestpath.model;

import java.util.LinkedList;
import java.util.List;

public class Output {
    private boolean mPathPossible;
    private int mTotalCost;
    private List<Integer> mPath;

    public Output() {
        mPath = new LinkedList();
    }

    public void setPathPossible(boolean mPathPossible) {
        this.mPathPossible = mPathPossible;
    }

    public void setTotalCost(int mTotalCost) {
        this.mTotalCost = mTotalCost;
    }

    public void setPath(List<Integer> mPath) {
        this.mPath = mPath;
    }

    public boolean isPathPossible() {
        return mPathPossible;
    }

    public int getTotalCost() {
        if (mTotalCost < 0)
            return 0;
        return mTotalCost;
    }

    public List<Integer> getPath() {
        return mPath;
    }
}
