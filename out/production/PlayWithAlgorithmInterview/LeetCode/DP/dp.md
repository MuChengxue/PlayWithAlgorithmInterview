递归的过程中会出现重叠的子问题，
为了减少不必要的重叠子问题（最优子问题）的计算，
可采用自顶向下的记忆化搜索方法，
或者自底向上的动态规划策略，
记录各个子问题的解，避免重复计算

Rob_198
状态：
考虑偷的时候偷取[x...n-1]范围里的房子，这是函数的定义
根据对状态的定义，决定状态的定义（状态转移方程）：
f(x)=max{v(x)+f(x+2),v(x+1)+f(x+3),v(x+2)+f(x+4), ... v(n-3)+f(n-1),v(n-2),v(n-1)}

考虑偷的时候偷取[0...x]范围里的房子，这是函数的定义
根据对状态的定义，决定状态的定义（状态转移方程）：
f(x)=max{v(0),v(1),v(2)+f(0),v(3)+f(1),v(4)+f(2), ... v(x)+f(x-2) }
