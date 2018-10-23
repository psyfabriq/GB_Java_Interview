--перерывы 30 минут и более между фильмами — выводить по уменьшению длительности перерыва. Колонки «фильм 1», «время начала», «длительность», «время начала второго фильма», «длительность перерыва»;
SELECT
S1.id,
S1.film,
S1.start,
S1.duration,
S1.interval,
F2.title AS "film_2",
S2.ts_start AS "start_2",
DF2.duration AS "duration_2",
S2.id
FROM public.session S2
INNER JOIN (
	SELECT
		DISTINCT S.id AS "id",
		F1.title AS "film",
		S.ts_start AS "start",
		DF.duration AS "duration",
	    D.duration AS "interval",
		LEAD(S.id) OVER (ORDER BY S.id ) AS "nextitemid"
		FROM public.session S
		LEFT JOIN public.duration D ON D.id = S.interval_id
		LEFT JOIN public.films F1 ON F1.id = S.film_id
		LEFT JOIN public.duration DF ON DF.id = F1.duration_id
	) AS S1 ON S1.nextitemid = S2.id
	LEFT JOIN public.films F2 ON F2.id = S2.film_id
	LEFT JOIN public.duration DF2 ON DF2.id = F2.duration_id
ORDER BY S1.interval DESC
