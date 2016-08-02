package cn.wlmb.css.po;

import java.util.ArrayList;
import java.util.List;

public class CurrentstateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CurrentstateExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andOnlinecustomerIsNull() {
            addCriterion("onlineCustomer is null");
            return (Criteria) this;
        }

        public Criteria andOnlinecustomerIsNotNull() {
            addCriterion("onlineCustomer is not null");
            return (Criteria) this;
        }

        public Criteria andOnlinecustomerEqualTo(Long value) {
            addCriterion("onlineCustomer =", value, "onlinecustomer");
            return (Criteria) this;
        }

        public Criteria andOnlinecustomerNotEqualTo(Long value) {
            addCriterion("onlineCustomer <>", value, "onlinecustomer");
            return (Criteria) this;
        }

        public Criteria andOnlinecustomerGreaterThan(Long value) {
            addCriterion("onlineCustomer >", value, "onlinecustomer");
            return (Criteria) this;
        }

        public Criteria andOnlinecustomerGreaterThanOrEqualTo(Long value) {
            addCriterion("onlineCustomer >=", value, "onlinecustomer");
            return (Criteria) this;
        }

        public Criteria andOnlinecustomerLessThan(Long value) {
            addCriterion("onlineCustomer <", value, "onlinecustomer");
            return (Criteria) this;
        }

        public Criteria andOnlinecustomerLessThanOrEqualTo(Long value) {
            addCriterion("onlineCustomer <=", value, "onlinecustomer");
            return (Criteria) this;
        }

        public Criteria andOnlinecustomerIn(List<Long> values) {
            addCriterion("onlineCustomer in", values, "onlinecustomer");
            return (Criteria) this;
        }

        public Criteria andOnlinecustomerNotIn(List<Long> values) {
            addCriterion("onlineCustomer not in", values, "onlinecustomer");
            return (Criteria) this;
        }

        public Criteria andOnlinecustomerBetween(Long value1, Long value2) {
            addCriterion("onlineCustomer between", value1, value2, "onlinecustomer");
            return (Criteria) this;
        }

        public Criteria andOnlinecustomerNotBetween(Long value1, Long value2) {
            addCriterion("onlineCustomer not between", value1, value2, "onlinecustomer");
            return (Criteria) this;
        }

        public Criteria andOnlineserverIsNull() {
            addCriterion("onlineServer is null");
            return (Criteria) this;
        }

        public Criteria andOnlineserverIsNotNull() {
            addCriterion("onlineServer is not null");
            return (Criteria) this;
        }

        public Criteria andOnlineserverEqualTo(Long value) {
            addCriterion("onlineServer =", value, "onlineserver");
            return (Criteria) this;
        }

        public Criteria andOnlineserverNotEqualTo(Long value) {
            addCriterion("onlineServer <>", value, "onlineserver");
            return (Criteria) this;
        }

        public Criteria andOnlineserverGreaterThan(Long value) {
            addCriterion("onlineServer >", value, "onlineserver");
            return (Criteria) this;
        }

        public Criteria andOnlineserverGreaterThanOrEqualTo(Long value) {
            addCriterion("onlineServer >=", value, "onlineserver");
            return (Criteria) this;
        }

        public Criteria andOnlineserverLessThan(Long value) {
            addCriterion("onlineServer <", value, "onlineserver");
            return (Criteria) this;
        }

        public Criteria andOnlineserverLessThanOrEqualTo(Long value) {
            addCriterion("onlineServer <=", value, "onlineserver");
            return (Criteria) this;
        }

        public Criteria andOnlineserverIn(List<Long> values) {
            addCriterion("onlineServer in", values, "onlineserver");
            return (Criteria) this;
        }

        public Criteria andOnlineserverNotIn(List<Long> values) {
            addCriterion("onlineServer not in", values, "onlineserver");
            return (Criteria) this;
        }

        public Criteria andOnlineserverBetween(Long value1, Long value2) {
            addCriterion("onlineServer between", value1, value2, "onlineserver");
            return (Criteria) this;
        }

        public Criteria andOnlineserverNotBetween(Long value1, Long value2) {
            addCriterion("onlineServer not between", value1, value2, "onlineserver");
            return (Criteria) this;
        }

        public Criteria andServernumberIsNull() {
            addCriterion("ServerNumber is null");
            return (Criteria) this;
        }

        public Criteria andServernumberIsNotNull() {
            addCriterion("ServerNumber is not null");
            return (Criteria) this;
        }

        public Criteria andServernumberEqualTo(Long value) {
            addCriterion("ServerNumber =", value, "servernumber");
            return (Criteria) this;
        }

        public Criteria andServernumberNotEqualTo(Long value) {
            addCriterion("ServerNumber <>", value, "servernumber");
            return (Criteria) this;
        }

        public Criteria andServernumberGreaterThan(Long value) {
            addCriterion("ServerNumber >", value, "servernumber");
            return (Criteria) this;
        }

        public Criteria andServernumberGreaterThanOrEqualTo(Long value) {
            addCriterion("ServerNumber >=", value, "servernumber");
            return (Criteria) this;
        }

        public Criteria andServernumberLessThan(Long value) {
            addCriterion("ServerNumber <", value, "servernumber");
            return (Criteria) this;
        }

        public Criteria andServernumberLessThanOrEqualTo(Long value) {
            addCriterion("ServerNumber <=", value, "servernumber");
            return (Criteria) this;
        }

        public Criteria andServernumberIn(List<Long> values) {
            addCriterion("ServerNumber in", values, "servernumber");
            return (Criteria) this;
        }

        public Criteria andServernumberNotIn(List<Long> values) {
            addCriterion("ServerNumber not in", values, "servernumber");
            return (Criteria) this;
        }

        public Criteria andServernumberBetween(Long value1, Long value2) {
            addCriterion("ServerNumber between", value1, value2, "servernumber");
            return (Criteria) this;
        }

        public Criteria andServernumberNotBetween(Long value1, Long value2) {
            addCriterion("ServerNumber not between", value1, value2, "servernumber");
            return (Criteria) this;
        }

        public Criteria andCustomernumberIsNull() {
            addCriterion("CustomerNumber is null");
            return (Criteria) this;
        }

        public Criteria andCustomernumberIsNotNull() {
            addCriterion("CustomerNumber is not null");
            return (Criteria) this;
        }

        public Criteria andCustomernumberEqualTo(Long value) {
            addCriterion("CustomerNumber =", value, "customernumber");
            return (Criteria) this;
        }

        public Criteria andCustomernumberNotEqualTo(Long value) {
            addCriterion("CustomerNumber <>", value, "customernumber");
            return (Criteria) this;
        }

        public Criteria andCustomernumberGreaterThan(Long value) {
            addCriterion("CustomerNumber >", value, "customernumber");
            return (Criteria) this;
        }

        public Criteria andCustomernumberGreaterThanOrEqualTo(Long value) {
            addCriterion("CustomerNumber >=", value, "customernumber");
            return (Criteria) this;
        }

        public Criteria andCustomernumberLessThan(Long value) {
            addCriterion("CustomerNumber <", value, "customernumber");
            return (Criteria) this;
        }

        public Criteria andCustomernumberLessThanOrEqualTo(Long value) {
            addCriterion("CustomerNumber <=", value, "customernumber");
            return (Criteria) this;
        }

        public Criteria andCustomernumberIn(List<Long> values) {
            addCriterion("CustomerNumber in", values, "customernumber");
            return (Criteria) this;
        }

        public Criteria andCustomernumberNotIn(List<Long> values) {
            addCriterion("CustomerNumber not in", values, "customernumber");
            return (Criteria) this;
        }

        public Criteria andCustomernumberBetween(Long value1, Long value2) {
            addCriterion("CustomerNumber between", value1, value2, "customernumber");
            return (Criteria) this;
        }

        public Criteria andCustomernumberNotBetween(Long value1, Long value2) {
            addCriterion("CustomerNumber not between", value1, value2, "customernumber");
            return (Criteria) this;
        }

        public Criteria andChatnumberIsNull() {
            addCriterion("chatNumber is null");
            return (Criteria) this;
        }

        public Criteria andChatnumberIsNotNull() {
            addCriterion("chatNumber is not null");
            return (Criteria) this;
        }

        public Criteria andChatnumberEqualTo(Long value) {
            addCriterion("chatNumber =", value, "chatnumber");
            return (Criteria) this;
        }

        public Criteria andChatnumberNotEqualTo(Long value) {
            addCriterion("chatNumber <>", value, "chatnumber");
            return (Criteria) this;
        }

        public Criteria andChatnumberGreaterThan(Long value) {
            addCriterion("chatNumber >", value, "chatnumber");
            return (Criteria) this;
        }

        public Criteria andChatnumberGreaterThanOrEqualTo(Long value) {
            addCriterion("chatNumber >=", value, "chatnumber");
            return (Criteria) this;
        }

        public Criteria andChatnumberLessThan(Long value) {
            addCriterion("chatNumber <", value, "chatnumber");
            return (Criteria) this;
        }

        public Criteria andChatnumberLessThanOrEqualTo(Long value) {
            addCriterion("chatNumber <=", value, "chatnumber");
            return (Criteria) this;
        }

        public Criteria andChatnumberIn(List<Long> values) {
            addCriterion("chatNumber in", values, "chatnumber");
            return (Criteria) this;
        }

        public Criteria andChatnumberNotIn(List<Long> values) {
            addCriterion("chatNumber not in", values, "chatnumber");
            return (Criteria) this;
        }

        public Criteria andChatnumberBetween(Long value1, Long value2) {
            addCriterion("chatNumber between", value1, value2, "chatnumber");
            return (Criteria) this;
        }

        public Criteria andChatnumberNotBetween(Long value1, Long value2) {
            addCriterion("chatNumber not between", value1, value2, "chatnumber");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}