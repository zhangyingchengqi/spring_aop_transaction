1. 记录每个业务层的方法调用的时间   v

2. 记录每个业务层的方法执行完毕的时间   V  后置增加 (   After, After return  ,  After throwing  )

3. 记录每个方法执行时的参数   v   非around advice用JointPoint             around advice   ProceedingJointPoint

4. 记录每个业务层的方法执行的时长   around advice   ProceedingJointPoint

5。 不能对原有系统的代码进行大的改变. 