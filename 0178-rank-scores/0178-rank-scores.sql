# Write your MySQL query statement below
select *
from (
    select
        score,
        dense_rank() over(
            order by score desc
        ) as 'rank'
        from Scores
    )
as temp