# Write your MySQL query statement below
with rank_cte as(
    select d.name as Department,
    e.name as Employee,
    e.salary as Salary,
    dense_rank() over(
        partition by d.id
        order by e.salary desc
    ) as rn
    from Employee e
    join Department d 
    on e.departmentId = d.id
)

select Department,
Employee,
Salary
from rank_cte
where rn <=3