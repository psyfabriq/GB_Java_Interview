--отсортированные по возрастанию времени. Выводить надо колонки «фильм 1», «время начала», «длительность», «фильм 2», «время начала», «длительность»;
SELECT F.title, S.ts_start, D.duration  FROM public.session S INNER JOIN public.films F ON S.film_id = F.id INNER JOIN public.duration D  ON F.duration_id = D.id
