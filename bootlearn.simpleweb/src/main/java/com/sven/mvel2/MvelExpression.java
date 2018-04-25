package com.sven.mvel2;

import org.mvel2.ParserContext;
import org.mvel2.compiler.CompiledExpression;
import org.mvel2.compiler.ExpressionCompiler;

/**
 * Created by sven on 2017/1/12.
 */
public class MvelExpression {
    private String exp;
    private ParserContext pc;
    private CompiledExpression ce = null;

    /**
     * 构造方法
     *
     * @param exp	运算表达式
     * @param pc	ParserContext对象
     */
    public MvelExpression(String exp, ParserContext pc) {
        this.exp = exp;
        this.pc = pc;
    }

    /**
     * 取得编译后的运算表达式
     *
     * @author 	Boyuan.Bao
     * @return	编译后的运算表达式
     */
//	public CompiledExpression getCompiledExpression() {
//		if(ce == null) {
//			ce = new ExpressionCompiler(exp,pc).compile();
//		}
//
//		return ce;
//	}

    public CompiledExpression getCompiledExpression() {
        if(ce == null) {
            String fExp = MvelExpressionUtil.getFormatedExpression(exp);
            ce = new ExpressionCompiler(fExp,pc).compile();
        }

        return ce;
    }

    /**
     * 取得运算表达式
     *
     * @author Boyuan.Bao
     * @return 运算表达式
     */
    public String getExp() {
        return exp;
    }
}
