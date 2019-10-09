package task2.task2.database;

import task2.task2.Crime;
import task2.task2.database.CrimeDbSchema.CrimeTable;
import android.database.Cursor;
import android.database.CursorWrapper;

import java.util.Date;
import java.util.UUID;

public class CrimeCursorWrapper extends CursorWrapper {
    public CrimeCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Crime getCrime() {
        String uuidString = getString(getColumnIndex(CrimeTable.Cols.UUID));
        String title = getString(getColumnIndex(CrimeTable.Cols.TITLE));
        long date = getLong(getColumnIndex(CrimeTable.Cols.DATE));
        int isSolved = getInt(getColumnIndex(CrimeTable.Cols.SOLVED));
        String suspect = getString(getColumnIndex(CrimeTable.Cols.SUSPECT));
        int isDisliked = getInt(getColumnIndex(CrimeTable.Cols.DISLIKED));
        Double latitude = getDouble(getColumnIndex(CrimeTable.Cols.LATITUDE));
        Double longitude = getDouble(getColumnIndex(CrimeTable.Cols.LONGITUDE));

        Crime crime = new Crime(UUID.fromString(uuidString));
        crime.setTitle(title);
        crime.setDate(new Date(date));
        crime.setSolved(isSolved != 0);
        crime.setDisliked(isDisliked != 0);
        crime.setSuspect(suspect);
        crime.setLongitude(longitude);
        crime.setLatitude(latitude);

        return crime;

        //return null;
    }
}
