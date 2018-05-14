package com.google.zxing.client.result;

/* compiled from: TbsSdkJava */
public final class AddressBookParsedResult extends ParsedResult {
    private final String[] addressTypes;
    private final String[] addresses;
    private final String birthday;
    private final String[] emailTypes;
    private final String[] emails;
    private final String[] geo;
    private final String instantMessenger;
    private final String[] names;
    private final String[] nicknames;
    private final String note;
    private final String org;
    private final String[] phoneNumbers;
    private final String[] phoneTypes;
    private final String pronunciation;
    private final String title;
    private final String[] urls;

    public AddressBookParsedResult(String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4, String[] strArr5, String[] strArr6, String[] strArr7) {
        this(strArr, null, null, strArr2, strArr3, strArr4, strArr5, null, null, strArr6, strArr7, null, null, null, null, null);
    }

    public AddressBookParsedResult(String[] strArr, String[] strArr2, String str, String[] strArr3, String[] strArr4, String[] strArr5, String[] strArr6, String str2, String str3, String[] strArr7, String[] strArr8, String str4, String str5, String str6, String[] strArr9, String[] strArr10) {
        super(ParsedResultType.ADDRESSBOOK);
        this.names = strArr;
        this.nicknames = strArr2;
        this.pronunciation = str;
        this.phoneNumbers = strArr3;
        this.phoneTypes = strArr4;
        this.emails = strArr5;
        this.emailTypes = strArr6;
        this.instantMessenger = str2;
        this.note = str3;
        this.addresses = strArr7;
        this.addressTypes = strArr8;
        this.org = str4;
        this.birthday = str5;
        this.title = str6;
        this.urls = strArr9;
        this.geo = strArr10;
    }

    public String[] getNames() {
        return this.names;
    }

    public String[] getNicknames() {
        return this.nicknames;
    }

    public String getPronunciation() {
        return this.pronunciation;
    }

    public String[] getPhoneNumbers() {
        return this.phoneNumbers;
    }

    public String[] getPhoneTypes() {
        return this.phoneTypes;
    }

    public String[] getEmails() {
        return this.emails;
    }

    public String[] getEmailTypes() {
        return this.emailTypes;
    }

    public String getInstantMessenger() {
        return this.instantMessenger;
    }

    public String getNote() {
        return this.note;
    }

    public String[] getAddresses() {
        return this.addresses;
    }

    public String[] getAddressTypes() {
        return this.addressTypes;
    }

    public String getTitle() {
        return this.title;
    }

    public String getOrg() {
        return this.org;
    }

    public String[] getURLs() {
        return this.urls;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public String[] getGeo() {
        return this.geo;
    }

    public String getDisplayResult() {
        StringBuilder stringBuilder = new StringBuilder(100);
        ParsedResult.maybeAppend(this.names, stringBuilder);
        ParsedResult.maybeAppend(this.nicknames, stringBuilder);
        ParsedResult.maybeAppend(this.pronunciation, stringBuilder);
        ParsedResult.maybeAppend(this.title, stringBuilder);
        ParsedResult.maybeAppend(this.org, stringBuilder);
        ParsedResult.maybeAppend(this.addresses, stringBuilder);
        ParsedResult.maybeAppend(this.phoneNumbers, stringBuilder);
        ParsedResult.maybeAppend(this.emails, stringBuilder);
        ParsedResult.maybeAppend(this.instantMessenger, stringBuilder);
        ParsedResult.maybeAppend(this.urls, stringBuilder);
        ParsedResult.maybeAppend(this.birthday, stringBuilder);
        ParsedResult.maybeAppend(this.geo, stringBuilder);
        ParsedResult.maybeAppend(this.note, stringBuilder);
        return stringBuilder.toString();
    }
}
