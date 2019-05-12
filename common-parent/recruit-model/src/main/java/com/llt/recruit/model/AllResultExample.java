package com.llt.recruit.model;

import java.util.ArrayList;
import java.util.List;

public class AllResultExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AllResultExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBlankResultIsNull() {
            addCriterion("blank_Result is null");
            return (Criteria) this;
        }

        public Criteria andBlankResultIsNotNull() {
            addCriterion("blank_Result is not null");
            return (Criteria) this;
        }

        public Criteria andBlankResultEqualTo(Integer value) {
            addCriterion("blank_Result =", value, "blankResult");
            return (Criteria) this;
        }

        public Criteria andBlankResultNotEqualTo(Integer value) {
            addCriterion("blank_Result <>", value, "blankResult");
            return (Criteria) this;
        }

        public Criteria andBlankResultGreaterThan(Integer value) {
            addCriterion("blank_Result >", value, "blankResult");
            return (Criteria) this;
        }

        public Criteria andBlankResultGreaterThanOrEqualTo(Integer value) {
            addCriterion("blank_Result >=", value, "blankResult");
            return (Criteria) this;
        }

        public Criteria andBlankResultLessThan(Integer value) {
            addCriterion("blank_Result <", value, "blankResult");
            return (Criteria) this;
        }

        public Criteria andBlankResultLessThanOrEqualTo(Integer value) {
            addCriterion("blank_Result <=", value, "blankResult");
            return (Criteria) this;
        }

        public Criteria andBlankResultIn(List<Integer> values) {
            addCriterion("blank_Result in", values, "blankResult");
            return (Criteria) this;
        }

        public Criteria andBlankResultNotIn(List<Integer> values) {
            addCriterion("blank_Result not in", values, "blankResult");
            return (Criteria) this;
        }

        public Criteria andBlankResultBetween(Integer value1, Integer value2) {
            addCriterion("blank_Result between", value1, value2, "blankResult");
            return (Criteria) this;
        }

        public Criteria andBlankResultNotBetween(Integer value1, Integer value2) {
            addCriterion("blank_Result not between", value1, value2, "blankResult");
            return (Criteria) this;
        }

        public Criteria andChoiceResultIsNull() {
            addCriterion("choice_Result is null");
            return (Criteria) this;
        }

        public Criteria andChoiceResultIsNotNull() {
            addCriterion("choice_Result is not null");
            return (Criteria) this;
        }

        public Criteria andChoiceResultEqualTo(Integer value) {
            addCriterion("choice_Result =", value, "choiceResult");
            return (Criteria) this;
        }

        public Criteria andChoiceResultNotEqualTo(Integer value) {
            addCriterion("choice_Result <>", value, "choiceResult");
            return (Criteria) this;
        }

        public Criteria andChoiceResultGreaterThan(Integer value) {
            addCriterion("choice_Result >", value, "choiceResult");
            return (Criteria) this;
        }

        public Criteria andChoiceResultGreaterThanOrEqualTo(Integer value) {
            addCriterion("choice_Result >=", value, "choiceResult");
            return (Criteria) this;
        }

        public Criteria andChoiceResultLessThan(Integer value) {
            addCriterion("choice_Result <", value, "choiceResult");
            return (Criteria) this;
        }

        public Criteria andChoiceResultLessThanOrEqualTo(Integer value) {
            addCriterion("choice_Result <=", value, "choiceResult");
            return (Criteria) this;
        }

        public Criteria andChoiceResultIn(List<Integer> values) {
            addCriterion("choice_Result in", values, "choiceResult");
            return (Criteria) this;
        }

        public Criteria andChoiceResultNotIn(List<Integer> values) {
            addCriterion("choice_Result not in", values, "choiceResult");
            return (Criteria) this;
        }

        public Criteria andChoiceResultBetween(Integer value1, Integer value2) {
            addCriterion("choice_Result between", value1, value2, "choiceResult");
            return (Criteria) this;
        }

        public Criteria andChoiceResultNotBetween(Integer value1, Integer value2) {
            addCriterion("choice_Result not between", value1, value2, "choiceResult");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_Id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_Id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_Id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_Id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_Id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_Id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_Id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_Id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_Id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_Id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_Id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_Id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andWriteResultIsNull() {
            addCriterion("write_Result is null");
            return (Criteria) this;
        }

        public Criteria andWriteResultIsNotNull() {
            addCriterion("write_Result is not null");
            return (Criteria) this;
        }

        public Criteria andWriteResultEqualTo(Integer value) {
            addCriterion("write_Result =", value, "writeResult");
            return (Criteria) this;
        }

        public Criteria andWriteResultNotEqualTo(Integer value) {
            addCriterion("write_Result <>", value, "writeResult");
            return (Criteria) this;
        }

        public Criteria andWriteResultGreaterThan(Integer value) {
            addCriterion("write_Result >", value, "writeResult");
            return (Criteria) this;
        }

        public Criteria andWriteResultGreaterThanOrEqualTo(Integer value) {
            addCriterion("write_Result >=", value, "writeResult");
            return (Criteria) this;
        }

        public Criteria andWriteResultLessThan(Integer value) {
            addCriterion("write_Result <", value, "writeResult");
            return (Criteria) this;
        }

        public Criteria andWriteResultLessThanOrEqualTo(Integer value) {
            addCriterion("write_Result <=", value, "writeResult");
            return (Criteria) this;
        }

        public Criteria andWriteResultIn(List<Integer> values) {
            addCriterion("write_Result in", values, "writeResult");
            return (Criteria) this;
        }

        public Criteria andWriteResultNotIn(List<Integer> values) {
            addCriterion("write_Result not in", values, "writeResult");
            return (Criteria) this;
        }

        public Criteria andWriteResultBetween(Integer value1, Integer value2) {
            addCriterion("write_Result between", value1, value2, "writeResult");
            return (Criteria) this;
        }

        public Criteria andWriteResultNotBetween(Integer value1, Integer value2) {
            addCriterion("write_Result not between", value1, value2, "writeResult");
            return (Criteria) this;
        }

        public Criteria andInterviewResultIsNull() {
            addCriterion("Interview_Result is null");
            return (Criteria) this;
        }

        public Criteria andInterviewResultIsNotNull() {
            addCriterion("Interview_Result is not null");
            return (Criteria) this;
        }

        public Criteria andInterviewResultEqualTo(Integer value) {
            addCriterion("Interview_Result =", value, "interviewResult");
            return (Criteria) this;
        }

        public Criteria andInterviewResultNotEqualTo(Integer value) {
            addCriterion("Interview_Result <>", value, "interviewResult");
            return (Criteria) this;
        }

        public Criteria andInterviewResultGreaterThan(Integer value) {
            addCriterion("Interview_Result >", value, "interviewResult");
            return (Criteria) this;
        }

        public Criteria andInterviewResultGreaterThanOrEqualTo(Integer value) {
            addCriterion("Interview_Result >=", value, "interviewResult");
            return (Criteria) this;
        }

        public Criteria andInterviewResultLessThan(Integer value) {
            addCriterion("Interview_Result <", value, "interviewResult");
            return (Criteria) this;
        }

        public Criteria andInterviewResultLessThanOrEqualTo(Integer value) {
            addCriterion("Interview_Result <=", value, "interviewResult");
            return (Criteria) this;
        }

        public Criteria andInterviewResultIn(List<Integer> values) {
            addCriterion("Interview_Result in", values, "interviewResult");
            return (Criteria) this;
        }

        public Criteria andInterviewResultNotIn(List<Integer> values) {
            addCriterion("Interview_Result not in", values, "interviewResult");
            return (Criteria) this;
        }

        public Criteria andInterviewResultBetween(Integer value1, Integer value2) {
            addCriterion("Interview_Result between", value1, value2, "interviewResult");
            return (Criteria) this;
        }

        public Criteria andInterviewResultNotBetween(Integer value1, Integer value2) {
            addCriterion("Interview_Result not between", value1, value2, "interviewResult");
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