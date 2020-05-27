package com.hx.swagger2.toos;

public abstract class AbstractApiParam implements ICheck {
    public AbstractApiParam() {
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof AbstractApiParam)) {
            return false;
        } else {
            AbstractApiParam other = (AbstractApiParam)o;
            return other.canEqual(this);
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof AbstractApiParam;
    }

    public int hashCode() {
//        int result = true;
        return 1;
    }

    public String toString() {
        return "AbstractApiParam()";
    }
}

