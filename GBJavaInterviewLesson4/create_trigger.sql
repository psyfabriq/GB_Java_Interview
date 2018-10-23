CREATE OR REPLACE FUNCTION trigger_set_timestamp_stop()
RETURNS TRIGGER AS $$
DECLARE
	interval_val interval;
	last_stop timestamp;
	last_interval interval;
BEGIN

	IF NEW.ts_start IS NOT NULL AND NEW.interval_id IS NOT NULL THEN
	    SELECT duration INTO interval_val FROM public.duration WHERE id=(SELECT duration_id FROM public.films WHERE id =NEW.film_id) ;
  		NEW.ts_stop = NEW.ts_start + interval_val;
		IF (TG_OP = 'INSERT') THEN
			SELECT s.ts_stop, d.duration INTO last_stop, last_interval FROM public.session s , public.duration d WHERE d.id = s.interval_id ORDER BY s.id DESC LIMIT 1;
			IF last_stop IS NOT NULL THEN
				last_stop = last_stop + last_interval;
				IF last_stop > NEW.ts_start THEN
					RAISE EXCEPTION 'Another movie at this time : %.', '';
				END IF;
			END IF;
		END IF;
	END IF;

  RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE   TRIGGER set_timestamp_stop
BEFORE INSERT OR UPDATE ON session
FOR EACH ROW
EXECUTE PROCEDURE trigger_set_timestamp_stop();
