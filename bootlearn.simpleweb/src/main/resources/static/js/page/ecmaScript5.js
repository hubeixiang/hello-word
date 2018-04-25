/**
 * Created by 123 on 2016/10/11.
 */
"use strict"
//根据ECMAScript3和非严格的ECMAScript5对函数调用的规定,调用上下文(this的值)是全局对象,然而在严格模式下调用上下文则是undefined
//定义并调用一个函数来确定当前的脚本运行时是否是严格模式
var strict = (function () {
    return !this;
}());

/*
 var o = {};
 function f(){};
 给对象o定义了方法m()
 o.m = f;
 调用它时像这样 o.m();
 或者参数调用o.m(x,y);
 像上面的代码是一个调用表达式:它包含一个函数表达式o.m,以及两个实参表达式x和y,函数表达式本身就是一个属性访问表达式,这意味着该函数被当成一个方法,而不是做为一个普通函数来调用.
 对方法调用的参数和返回值的处理,和它上面所描述的普通函数调用完全一致。
 但是,方法调用和函数调用有一个重要的区别,即:调用上下文
 属性访问表达式的有两部分组成:一个对象(本例中的o)和属性名(m).
 在像这样的方法调用表达式里,对象o成为调用上下文,函数体可以使用关键字this引用该对象，下面是一个具体的例子:
 var cacluator = {//对象直接量
 operand1 : 1,
 operand2 : 1,
 add: function(){
 //注意this关键字的用法,this指代当前对象
 this.result = this.operand1 + this.operand2;
 }
 };
 cacluator.add()		//这个方法调用计算1+1的结果
 cacluator.result	// =>2

 和变量不同,this关键字没有作用域的限制,嵌套的函数不会从调用它的函数中继承this.
 如果嵌套函数做为方法调用,其this的值指向调用它的对象。
 如果嵌套函数做为函数调用,其this值不是全局对象(非严格模式下)就是undefined(严格模式下)。很多人误认为调用嵌套函数时this会指向调用外层函数的上下文。
 如果你想访问这个外部函数的this值,需要将this的值保存在一个变量里,这个变量和内部函数都同在一个作用域内。通常使用变量self来保存this,比如:
 var o = {								//对象o
 m : function(){						//对象o中的方法m()
 var self = this;				//将this值保存到一个变量中
 console.log(o === this);		//"true" :this就是这个对象o
 f();							//调用辅助函数f()

 function f(){					//定义一个嵌套函数f()
 console.log(this === o);	//"false" :this的值是全局对象或者undefined
 console.log(self === o);	//"true" :self值外部函数this的值
 }
 }
 };
 */

function inherit(p) {
    if (p == null) {                        //p是一个对象,但不能是null
        throw TypeError();
    }
    if (Object.create) {                     //如果Object.create存在,直接使用它
        return Object.create(p);
    }
    var t = typeof p;                       //否则进一步检测
    if (t !== "function") {
        if (t !== "object") {
            throw TypeError();
        }
    }
    function f() {
    };                                       //定义一个空的函数
    f.prototype = p;                         //将其原型属性设置为p
    return new f();                         //使用f()创建p的继承对象
}

function testmylearn() {
    var o = {
        x: 2
    }
    var p = inherit(o);
    console.log(p);

    var op = {
        x: 1.0,
        y: 1.0,

        //r是可读写的存取器属性
        get r() {
            return Math.sqrt(this.x * this.x + this.y * this.y);
        },
        set r(newvalue) {
            var oldvalue = Math.sqrt(this.x * this.x + this.y * this.y);
            var ratio = newvalue / oldvalue;
            this.x *= ratio;
            this.y *= ratio;
        },
        //theta是只读存取器属性,它只有getter方法
        get getta() {
            return Math.atan2(this.y, this.x);
        }
    };

    var serialnum = {
        //这个数据属性包含下一个序列号
        //$符号暗示这个属性是一个私有属性
        $n: 0,

        //返回当前值,然后自增
        get next() {
            return this.$n++
        },

        //给$n设置新的值,但只有它比当前值大时才设置成功
        set next(n) {
            if (n > this.$n) this.$n = n;
            else throw "序列号的值不能比当前值小";
        }
    };

    var q = inherit(op);
    q.x = 2, q.y = 2;
    console.log(q.r);
    console.log(q.getta);
    console.log(op.r);
    console.log(op.getta);
    var newvalue = 5;
    op.r = 5;
    console.log(op.r);
    console.log(op.getta);

    var keys = Object.keys(q);
    var values = [];
    for (var i = 0; i < keys.length; i++) {
        var key = keys[i];
        values[i] = q[key];
    }

    console.log(keys);
    console.log(values);

    var keys1 = Object.keys(op);
    var values1 = [];
    for (var i = 0; i < keys1.length; i++) {
        var key = keys1[i];
        values1[i] = op[key];
    }

    console.log(keys1);
    console.log(values1);

    var data = ["a", "b", "c", "d"];
    data.forEach(function (x) {
        console.log("---data:" + x);
    });

    //判断数组的操作
    var r = [1, 2, 3, 4, 5, 6];
    var s = ["a", "b", "c", r, "e", "f"];

    console.log(r);
    console.log(s);
    r.unshift("r");
    console.log(r);
    console.log(s);

    var s1 = s.concat(r);
    console.log(r);
    console.log(s1);

    r.push("r");
    console.log(r);
    console.log(s);
    console.log(s1);

    var f = function () {
        return 0;
    };

    console.log(f);
    f.x = 1;

    console.log(f);
    console.log("============" + f.x);
    console.log("============" + f.a);

    var xf = testdefinefunction();
    console.log(xf);

    var o1 = extend(o);
    var ox = {"a": 1};
    var oa = extend(o, ox);
    var oop = extend(o, op);

    var n = 1;
    var c = counter(n);
    console.log("n===" + n)
    console.log(c.count);
    console.log(c.count);
    c.count = 2000;
    console.log(c.count);
    console.log(c.count);
    n = 3000;
    console.log(c.count);
    console.log(c.count);
    console.log("n===" + n)

    var mm = {cc: 1};
    var mc = counter_new1(mm);
    console.log("cc===" + mm.cc)
    console.log(mc.count);
    console.log(mc.count);
    mc.count = 2000;
    console.log(mc.count);
    console.log(mc.count);
    mm.cc = 3000;
    console.log(mc.count);
    console.log(mc.count);
    console.log("cc===" + mm.cc)
    var funcs = constfuncs();
    console.log(funcs[5]());
    console.log("-----end-----")
}

function testdefinefunction() {
    //输出对象o的每个属性名和值,返回undefined
    function printprop(o) {
        for (var p in o)
            console.log(p + ":" + o[p] + "\n");
    }

    //计算两个笛卡尔坐标的距离
    function distince(x1, y1, x2, y2) {
        var dx = x1 - x2;
        var dy = y1 - y2;
        return Math.sqrt(dx * dx + dy * dy);
    }

    //计算阶乘的递归函数(调用自身的函数)
    //x!的值是从x到x递减(步长为1)的值的累乘
    function factorial(x) {
        if (x <= 1) return 1;
        return x * factorial(x - 1);
    }

    //这个函数表达式定义了一个函数用来求传入参数的平方
    //注意我们把它赋值为一个变量
    var square = function (x) {
        return x * x
    };

    //函数表达式可以包含名称,在递归调用时很有用
    var f = function fact(x) {
        if (x <= 1) {
            return 1;
        } else {
            return x * fact(x - 1);
        }
    }

    //函数表达式也可以做为参数传给其它函数
    var data = [1, 3, 2, 6, 5, 4];
    data.sort(function (a, b) {
        var v = 2;
        while (v > 0) {
            //function xvf(x) 与 var xvf = funciton(x) 不能在循环,if,try/catch/finally中定义
            //但是这种表达式定义的函数是可以定义并使用的
            v = (function (v) {
                return v - 1;
            }(v));
        }
        return a - b;
    });

    //函数表达式有时定义后可以立即调用
    var tensquared = (function (x) {
        return x * x;
    }(10));

    console.log(data);
    console.log(tensquared);
    return testdefinefunction;
    //return this;
}

function extend(o, p) {
    console.log("extend(o,p)-----------" + o);
    for (var prop in p) {
        o[prop] = p[prop];
    }
    return o;
};

var extend = (function () {
    //在修复前面的extend之前,先检查是否存在IE bug
    for (var p in {toString: null}) {
        //如果代码执行到这里,那么for/in循环会正确工作并返回
        return function (o) {
            console.log("extend(o,p)===========" + o);
            for (var i = 1; i < arguments.length; i++) {
                var source = arguments[i];
                for (var prop in source) {
                    o[prop] = source[prop];
                }
            }
            ;
            return o;
        };
    }

    //如果代码执行到这里,说明for/in循环不会枚举测试对象的toString属性
    //因此返回另外一个版本的extend()函数,这个函数显示测试Object.prototype中的不可枚举的属性
    return function patched_extend(o) {
        console.log("extend(o,p)+++++++++++" + o);
        for (var i = 1; i < arguments.length; i++) {
            var source = arguments[i];
            //复制所有的可枚举属性
            for (var prop in source) {
                o[prop] = source[prop];
            }
            //现在检测特殊属性
            for (var j = 0; j < prototypes.length; j++) {
                prop = prototypes[j];
                if (source.hasOwnProperty(prop)) {
                    o[prop] = source[prop];
                }
            }
        }
    };
    var prototypes = ["toString", "valueOf", "constructor", "hasOwnProperty", "isPrototypeOf", "propertyIsEnumerable", "toLocaleString"];
}());

function counter(n) {
    return {
        //属性getter方法返回并给私有计数器var递增1
        get count() {
            return n++;
        },
        //属性setter方法不允许n递减
        set count(m) {
            if (m >= n) {
                n = m;
            } else {
                throw Error("count can only be set to a larger value");
            }
        }
    };
}

function counter_new(n) {
    return {
        //属性getter方法返回并给私有计数器var递增1
        get count() {
            return n.cc++;
        },
        //属性setter方法不允许n递减
        set count(m) {
            if (m >= n.cc) {
                n.cc = m;
            } else {
                throw Error("count can only be set to a larger value");
            }
        }
    };
}

function counter_new1(n) {
    var x = n.cc;
    return {
        //属性getter方法返回并给私有计数器var递增1
        get count() {
            return x++;
        },
        //属性setter方法不允许n递减
        set count(m) {
            if (m >= x) {
                x = m;
            } else {
                throw Error("count can only be set to a larger value");
            }
        }
    };
}

function constfuncs() {
    var funcs = [];
    for (var i = 0; i < 10; i++) {
        funcs[i] = function () {
            return i
        };
    }
    return funcs;
}

//将对象o中名为m的方法替换为另一个方法
//可以在调用原始的方法之前和之后记录日消息
function trace(o, m) {
    var original = o[m];
    o[m] = function () {
        console.log(new Date(), "Entering:", m);
        var result = original.apply(o, arguments);
        console.log(new Date(), "Exiting:", m);
        return result;
    }
}

function isFunction(x) {
    return Object.prototype.toString.call(x) === "[object Function]";
}

function isArray(x) {
    var isArrayVar = Function.isArray || function (o) {
            return typeof o === "object" && Object.prototype.toString.call(o) === "object Array";
        };
    return isArrayVar(x);
}