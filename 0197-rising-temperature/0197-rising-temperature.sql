# Write your MySQL query statement below
select w.id as id
from Weather w
where w.temperature > (
    select w1.temperature
    from Weather w1
    where datediff(w.recordDate, w1.recordDate)=1
)