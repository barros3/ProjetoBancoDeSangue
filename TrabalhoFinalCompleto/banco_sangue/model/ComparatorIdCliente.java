package model;

import java.util.Comparator;

public class ComparatorIdCliente implements Comparator<Cliente>{

	@Override
	public int compare(Cliente o1, Cliente o2) {
		return o1.compareTo(o2);
	}

}
