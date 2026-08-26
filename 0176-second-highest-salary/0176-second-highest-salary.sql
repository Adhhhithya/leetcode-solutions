# Write your MySQL query statement below
select  (
    select salary
    from(
        select salary,
        dense_rank() over(
            order by salary desc
        )as rn
        from Employee
    ) as temp
    where rn=2
    limit 1
) as SecondHighestSalary