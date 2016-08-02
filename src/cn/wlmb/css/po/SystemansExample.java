package cn.wlmb.css.po;

import java.util.ArrayList;
import java.util.List;

public class SystemansExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SystemansExample() {
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

        public Criteria andSyanidIsNull() {
            addCriterion("syanId is null");
            return (Criteria) this;
        }

        public Criteria andSyanidIsNotNull() {
            addCriterion("syanId is not null");
            return (Criteria) this;
        }

        public Criteria andSyanidEqualTo(String value) {
            addCriterion("syanId =", value, "syanid");
            return (Criteria) this;
        }

        public Criteria andSyanidNotEqualTo(String value) {
            addCriterion("syanId <>", value, "syanid");
            return (Criteria) this;
        }

        public Criteria andSyanidGreaterThan(String value) {
            addCriterion("syanId >", value, "syanid");
            return (Criteria) this;
        }

        public Criteria andSyanidGreaterThanOrEqualTo(String value) {
            addCriterion("syanId >=", value, "syanid");
            return (Criteria) this;
        }

        public Criteria andSyanidLessThan(String value) {
            addCriterion("syanId <", value, "syanid");
            return (Criteria) this;
        }

        public Criteria andSyanidLessThanOrEqualTo(String value) {
            addCriterion("syanId <=", value, "syanid");
            return (Criteria) this;
        }

        public Criteria andSyanidLike(String value) {
            addCriterion("syanId like", value, "syanid");
            return (Criteria) this;
        }

        public Criteria andSyanidNotLike(String value) {
            addCriterion("syanId not like", value, "syanid");
            return (Criteria) this;
        }

        public Criteria andSyanidIn(List<String> values) {
            addCriterion("syanId in", values, "syanid");
            return (Criteria) this;
        }

        public Criteria andSyanidNotIn(List<String> values) {
            addCriterion("syanId not in", values, "syanid");
            return (Criteria) this;
        }

        public Criteria andSyanidBetween(String value1, String value2) {
            addCriterion("syanId between", value1, value2, "syanid");
            return (Criteria) this;
        }

        public Criteria andSyanidNotBetween(String value1, String value2) {
            addCriterion("syanId not between", value1, value2, "syanid");
            return (Criteria) this;
        }

        public Criteria andSywordIsNull() {
            addCriterion("syword is null");
            return (Criteria) this;
        }

        public Criteria andSywordIsNotNull() {
            addCriterion("syword is not null");
            return (Criteria) this;
        }

        public Criteria andSywordEqualTo(String value) {
            addCriterion("syword =", value, "syword");
            return (Criteria) this;
        }

        public Criteria andSywordNotEqualTo(String value) {
            addCriterion("syword <>", value, "syword");
            return (Criteria) this;
        }

        public Criteria andSywordGreaterThan(String value) {
            addCriterion("syword >", value, "syword");
            return (Criteria) this;
        }

        public Criteria andSywordGreaterThanOrEqualTo(String value) {
            addCriterion("syword >=", value, "syword");
            return (Criteria) this;
        }

        public Criteria andSywordLessThan(String value) {
            addCriterion("syword <", value, "syword");
            return (Criteria) this;
        }

        public Criteria andSywordLessThanOrEqualTo(String value) {
            addCriterion("syword <=", value, "syword");
            return (Criteria) this;
        }

        public Criteria andSywordLike(String value) {
            addCriterion("syword like", value, "syword");
            return (Criteria) this;
        }

        public Criteria andSywordNotLike(String value) {
            addCriterion("syword not like", value, "syword");
            return (Criteria) this;
        }

        public Criteria andSywordIn(List<String> values) {
            addCriterion("syword in", values, "syword");
            return (Criteria) this;
        }

        public Criteria andSywordNotIn(List<String> values) {
            addCriterion("syword not in", values, "syword");
            return (Criteria) this;
        }

        public Criteria andSywordBetween(String value1, String value2) {
            addCriterion("syword between", value1, value2, "syword");
            return (Criteria) this;
        }

        public Criteria andSywordNotBetween(String value1, String value2) {
            addCriterion("syword not between", value1, value2, "syword");
            return (Criteria) this;
        }

        public Criteria andSycontentIsNull() {
            addCriterion("sycontent is null");
            return (Criteria) this;
        }

        public Criteria andSycontentIsNotNull() {
            addCriterion("sycontent is not null");
            return (Criteria) this;
        }

        public Criteria andSycontentEqualTo(String value) {
            addCriterion("sycontent =", value, "sycontent");
            return (Criteria) this;
        }

        public Criteria andSycontentNotEqualTo(String value) {
            addCriterion("sycontent <>", value, "sycontent");
            return (Criteria) this;
        }

        public Criteria andSycontentGreaterThan(String value) {
            addCriterion("sycontent >", value, "sycontent");
            return (Criteria) this;
        }

        public Criteria andSycontentGreaterThanOrEqualTo(String value) {
            addCriterion("sycontent >=", value, "sycontent");
            return (Criteria) this;
        }

        public Criteria andSycontentLessThan(String value) {
            addCriterion("sycontent <", value, "sycontent");
            return (Criteria) this;
        }

        public Criteria andSycontentLessThanOrEqualTo(String value) {
            addCriterion("sycontent <=", value, "sycontent");
            return (Criteria) this;
        }

        public Criteria andSycontentLike(String value) {
            addCriterion("sycontent like", value, "sycontent");
            return (Criteria) this;
        }

        public Criteria andSycontentNotLike(String value) {
            addCriterion("sycontent not like", value, "sycontent");
            return (Criteria) this;
        }

        public Criteria andSycontentIn(List<String> values) {
            addCriterion("sycontent in", values, "sycontent");
            return (Criteria) this;
        }

        public Criteria andSycontentNotIn(List<String> values) {
            addCriterion("sycontent not in", values, "sycontent");
            return (Criteria) this;
        }

        public Criteria andSycontentBetween(String value1, String value2) {
            addCriterion("sycontent between", value1, value2, "sycontent");
            return (Criteria) this;
        }

        public Criteria andSycontentNotBetween(String value1, String value2) {
            addCriterion("sycontent not between", value1, value2, "sycontent");
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