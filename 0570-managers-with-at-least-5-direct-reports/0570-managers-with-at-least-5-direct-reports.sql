# Write your MySQL query statement below
select
    m.name
from Employee m
left join Employee e
on e.managerId = m.id
group by m.id
having count(*) >=5