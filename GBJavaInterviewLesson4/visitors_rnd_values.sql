INSERT INTO public.visitor (session_id) SELECT  id FROM public.session  ORDER BY random() LIMIT 1
