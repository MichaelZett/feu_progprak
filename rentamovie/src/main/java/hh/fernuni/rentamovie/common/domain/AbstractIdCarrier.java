package hh.fernuni.rentamovie.common.domain;

public abstract class AbstractIdCarrier implements IdCarrier {
	protected long id;

	public AbstractIdCarrier() {
		this(IdRepository.getNextId());
	}

	public AbstractIdCarrier(long id) {
		super();
		this.id = id;
	}

	@Override
	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "id=" + id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractIdCarrier other = (AbstractIdCarrier) obj;
		if (id != other.id)
			return false;
		return true;
	}

}