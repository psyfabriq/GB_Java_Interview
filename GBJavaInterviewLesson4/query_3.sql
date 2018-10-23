--список фильмов, для каждого — с указанием общего числа посетителей за все время, среднего числа зрителей за сеанс и общей суммы сборов по каждому фильму (отсортировать по убыванию прибыли).
SELECT
F.title,
COUNT(V),
SUM(S.cost) AS "cost"
FROM public.films F
FULL OUTER JOIN public.session S ON S.film_id = F.id
FULL OUTER JOIN  public.visitor V ON V.session_id = S.id
GROUP BY F.title
ORDER BY cost DESC
