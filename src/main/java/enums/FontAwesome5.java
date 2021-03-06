package enums;

import helpers.Helpers;
import jiconfont.IconCode;
import jiconfont.IconFont;

import java.io.InputStream;
public enum FontAwesome5 implements IconCode {
    FA_500PX('\uF26E'),
    FA_ACCESSIBLE_ICON('\uF368'),
    FA_ACCUSOFT('\uF369'),
    FA_ACQUISITIONS_INCORPORATED('\uF6AF'),
    FA_AD('\uF641'),
    FA_ADDRESS_BOOK('\uF2B9'),
    FA_ADDRESS_CARD('\uF2BB'),
    FA_ADJUST('\uF042'),
    FA_ADN('\uF170'),
    FA_ADOBE('\uF778'),
    FA_ADVERSAL('\uF36A'),
    FA_AFFILIATETHEME('\uF36B'),
    FA_AIR_FRESHENER('\uF5D0'),
    FA_ALGOLIA('\uF36C'),
    FA_ALIGN_CENTER('\uF037'),
    FA_ALIGN_JUSTIFY('\uF039'),
    FA_ALIGN_LEFT('\uF036'),
    FA_ALIGN_RIGHT('\uF038'),
    FA_ALIPAY('\uF642'),
    FA_ALLERGIES('\uF461'),
    FA_AMAZON('\uF270'),
    FA_AMAZON_PAY('\uF42C'),
    FA_AMBULANCE('\uF0F9'),
    FA_AMERICAN_SIGN_LANGUAGE_INTERPRETING('\uF2A3'),
    FA_AMILIA('\uF36D'),
    FA_ANCHOR('\uF13D'),
    FA_ANDROID('\uF17B'),
    FA_ANGELLIST('\uF209'),
    FA_ANGLE_DOUBLE_DOWN('\uF103'),
    FA_ANGLE_DOUBLE_LEFT('\uF100'),
    FA_ANGLE_DOUBLE_RIGHT('\uF101'),
    FA_ANGLE_DOUBLE_UP('\uF102'),
    FA_ANGLE_DOWN('\uF107'),
    FA_ANGLE_LEFT('\uF104'),
    FA_ANGLE_RIGHT('\uF105'),
    FA_ANGLE_UP('\uF106'),
    FA_ANGRY('\uF556'),
    FA_ANGRYCREATIVE('\uF36E'),
    FA_ANGULAR('\uF420'),
    FA_ANKH('\uF644'),
    FA_APP_STORE('\uF36F'),
    FA_APP_STORE_IOS('\uF370'),
    FA_APPER('\uF371'),
    FA_APPLE('\uF179'),
    FA_APPLE_ALT('\uF5D1'),
    FA_APPLE_PAY('\uF415'),
    FA_ARCHIVE('\uF187'),
    FA_ARCHWAY('\uF557'),
    FA_ARROW_ALT_CIRCLE_DOWN('\uF358'),
    FA_ARROW_ALT_CIRCLE_LEFT('\uF359'),
    FA_ARROW_ALT_CIRCLE_RIGHT('\uF35A'),
    FA_ARROW_ALT_CIRCLE_UP('\uF35B'),
    FA_ARROW_CIRCLE_DOWN('\uF0AB'),
    FA_ARROW_CIRCLE_LEFT('\uF0A8'),
    FA_ARROW_CIRCLE_RIGHT('\uF0A9'),
    FA_ARROW_CIRCLE_UP('\uF0AA'),
    FA_ARROW_DOWN('\uF063'),
    FA_ARROW_LEFT('\uF060'),
    FA_ARROW_RIGHT('\uF061'),
    FA_ARROW_UP('\uF062'),
    FA_ARROWS_ALT('\uF0B2'),
    FA_ARROWS_ALT_H('\uF337'),
    FA_ARROWS_ALT_V('\uF338'),
    FA_ARTSTATION('\uF77A'),
    FA_ASSISTIVE_LISTENING_SYSTEMS('\uF2A2'),
    FA_ASTERISK('\uF069'),
    FA_ASYMMETRIK('\uF372'),
    FA_AT('\uF1FA'),
    FA_ATLAS('\uF558'),
    FA_ATLASSIAN('\uF77B'),
    FA_ATOM('\uF5D2'),
    FA_AUDIBLE('\uF373'),
    FA_AUDIO_DESCRIPTION('\uF29E'),
    FA_AUTOPREFIXER('\uF41C'),
    FA_AVIANEX('\uF374'),
    FA_AVIATO('\uF421'),
    FA_AWARD('\uF559'),
    FA_AWS('\uF375'),
    FA_BABY('\uF77C'),
    FA_BABY_CARRIAGE('\uF77D'),
    FA_BACKSPACE('\uF55A'),
    FA_BACKWARD('\uF04A'),
    FA_BALANCE_SCALE('\uF24E'),
    FA_BAN('\uF05E'),
    FA_BAND_AID('\uF462'),
    FA_BANDCAMP('\uF2D5'),
    FA_BARCODE('\uF02A'),
    FA_BARS('\uF0C9'),
    FA_BASEBALL_BALL('\uF433'),
    FA_BASKETBALL_BALL('\uF434'),
    FA_BATH('\uF2CD'),
    FA_BATTERY_EMPTY('\uF244'),
    FA_BATTERY_FULL('\uF240'),
    FA_BATTERY_HALF('\uF242'),
    FA_BATTERY_QUARTER('\uF243'),
    FA_BATTERY_THREE_QUARTERS('\uF241'),
    FA_BED('\uF236'),
    FA_BEER('\uF0FC'),
    FA_BEHANCE('\uF1B4'),
    FA_BEHANCE_SQUARE('\uF1B5'),
    FA_BELL('\uF0F3'),
    FA_BELL_SLASH('\uF1F6'),
    FA_BEZIER_CURVE('\uF55B'),
    FA_BIBLE('\uF647'),
    FA_BICYCLE('\uF206'),
    FA_BIMOBJECT('\uF378'),
    FA_BINOCULARS('\uF1E5'),
    FA_BIOHAZARD('\uF780'),
    FA_BIRTHDAY_CAKE('\uF1FD'),
    FA_BITBUCKET('\uF171'),
    FA_BITCOIN('\uF379'),
    FA_BITY('\uF37A'),
    FA_BLACK_TIE('\uF27E'),
    FA_BLACKBERRY('\uF37B'),
    FA_BLENDER('\uF517'),
    FA_BLENDER_PHONE('\uF6B6'),
    FA_BLIND('\uF29D'),
    FA_BLOG('\uF781'),
    FA_BLOGGER('\uF37C'),
    FA_BLOGGER_B('\uF37D'),
    FA_BLUETOOTH('\uF293'),
    FA_BLUETOOTH_B('\uF294'),
    FA_BOLD('\uF032'),
    FA_BOLT('\uF0E7'),
    FA_BOMB('\uF1E2'),
    FA_BONE('\uF5D7'),
    FA_BONG('\uF55C'),
    FA_BOOK('\uF02D'),
    FA_BOOK_DEAD('\uF6B7'),
    FA_BOOK_OPEN('\uF518'),
    FA_BOOK_READER('\uF5DA'),
    FA_BOOKMARK('\uF02E'),
    FA_BOWLING_BALL('\uF436'),
    FA_BOX('\uF466'),
    FA_BOX_OPEN('\uF49E'),
    FA_BOXES('\uF468'),
    FA_BRAILLE('\uF2A1'),
    FA_BRAIN('\uF5DC'),
    FA_BRIEFCASE('\uF0B1'),
    FA_BRIEFCASE_MEDICAL('\uF469'),
    FA_BROADCAST_TOWER('\uF519'),
    FA_BROOM('\uF51A'),
    FA_BRUSH('\uF55D'),
    FA_BTC('\uF15A'),
    FA_BUG('\uF188'),
    FA_BUILDING('\uF1AD'),
    FA_BULLHORN('\uF0A1'),
    FA_BULLSEYE('\uF140'),
    FA_BURN('\uF46A'),
    FA_BUROMOBELEXPERTE('\uF37F'),
    FA_BUS('\uF207'),
    FA_BUS_ALT('\uF55E'),
    FA_BUSINESS_TIME('\uF64A'),
    FA_BUYSELLADS('\uF20D'),
    FA_CALCULATOR('\uF1EC'),
    FA_CALENDAR('\uF133'),
    FA_CALENDAR_ALT('\uF073'),
    FA_CALENDAR_CHECK('\uF274'),
    FA_CALENDAR_DAY('\uF783'),
    FA_CALENDAR_MINUS('\uF272'),
    FA_CALENDAR_PLUS('\uF271'),
    FA_CALENDAR_TIMES('\uF273'),
    FA_CALENDAR_WEEK('\uF784'),
    FA_CAMERA('\uF030'),
    FA_CAMERA_RETRO('\uF083'),
    FA_CAMPGROUND('\uF6BB'),
    FA_CANADIAN_MAPLE_LEAF('\uF785'),
    FA_CANDY_CANE('\uF786'),
    FA_CANNABIS('\uF55F'),
    FA_CAPSULES('\uF46B'),
    FA_CAR('\uF1B9'),
    FA_CAR_ALT('\uF5DE'),
    FA_CAR_BATTERY('\uF5DF'),
    FA_CAR_CRASH('\uF5E1'),
    FA_CAR_SIDE('\uF5E4'),
    FA_CARET_DOWN('\uF0D7'),
    FA_CARET_LEFT('\uF0D9'),
    FA_CARET_RIGHT('\uF0DA'),
    FA_CARET_SQUARE_DOWN('\uF150'),
    FA_CARET_SQUARE_LEFT('\uF191'),
    FA_CARET_SQUARE_RIGHT('\uF152'),
    FA_CARET_SQUARE_UP('\uF151'),
    FA_CARET_UP('\uF0D8'),
    FA_CARROT('\uF787'),
    FA_CART_ARROW_DOWN('\uF218'),
    FA_CART_PLUS('\uF217'),
    FA_CASH_REGISTER('\uF788'),
    FA_CAT('\uF6BE'),
    FA_CC_AMAZON_PAY('\uF42D'),
    FA_CC_AMEX('\uF1F3'),
    FA_CC_APPLE_PAY('\uF416'),
    FA_CC_DINERS_CLUB('\uF24C'),
    FA_CC_DISCOVER('\uF1F2'),
    FA_CC_JCB('\uF24B'),
    FA_CC_MASTERCARD('\uF1F1'),
    FA_CC_PAYPAL('\uF1F4'),
    FA_CC_STRIPE('\uF1F5'),
    FA_CC_VISA('\uF1F0'),
    FA_CENTERCODE('\uF380'),
    FA_CENTOS('\uF789'),
    FA_CERTIFICATE('\uF0A3'),
    FA_CHAIR('\uF6C0'),
    FA_CHALKBOARD('\uF51B'),
    FA_CHALKBOARD_TEACHER('\uF51C'),
    FA_CHARGING_STATION('\uF5E7'),
    FA_CHART_AREA('\uF1FE'),
    FA_CHART_BAR('\uF080'),
    FA_CHART_LINE('\uF201'),
    FA_CHART_PIE('\uF200'),
    FA_CHECK('\uF00C'),
    FA_CHECK_CIRCLE('\uF058'),
    FA_CHECK_DOUBLE('\uF560'),
    FA_CHECK_SQUARE('\uF14A'),
    FA_CHESS('\uF439'),
    FA_CHESS_BISHOP('\uF43A'),
    FA_CHESS_BOARD('\uF43C'),
    FA_CHESS_KING('\uF43F'),
    FA_CHESS_KNIGHT('\uF441'),
    FA_CHESS_PAWN('\uF443'),
    FA_CHESS_QUEEN('\uF445'),
    FA_CHESS_ROOK('\uF447'),
    FA_CHEVRON_CIRCLE_DOWN('\uF13A'),
    FA_CHEVRON_CIRCLE_LEFT('\uF137'),
    FA_CHEVRON_CIRCLE_RIGHT('\uF138'),
    FA_CHEVRON_CIRCLE_UP('\uF139'),
    FA_CHEVRON_DOWN('\uF078'),
    FA_CHEVRON_LEFT('\uF053'),
    FA_CHEVRON_RIGHT('\uF054'),
    FA_CHEVRON_UP('\uF077'),
    FA_CHILD('\uF1AE'),
    FA_CHROME('\uF268'),
    FA_CHURCH('\uF51D'),
    FA_CIRCLE('\uF111'),
    FA_CIRCLE_NOTCH('\uF1CE'),
    FA_CITY('\uF64F'),
    FA_CLIPBOARD('\uF328'),
    FA_CLIPBOARD_CHECK('\uF46C'),
    FA_CLIPBOARD_LIST('\uF46D'),
    FA_CLOCK('\uF017'),
    FA_CLONE('\uF24D'),
    FA_CLOSED_CAPTIONING('\uF20A'),
    FA_CLOUD('\uF0C2'),
    FA_CLOUD_DOWNLOAD_ALT('\uF381'),
    FA_CLOUD_MEATBALL('\uF73B'),
    FA_CLOUD_MOON('\uF6C3'),
    FA_CLOUD_MOON_RAIN('\uF73C'),
    FA_CLOUD_RAIN('\uF73D'),
    FA_CLOUD_SHOWERS_HEAVY('\uF740'),
    FA_CLOUD_SUN('\uF6C4'),
    FA_CLOUD_SUN_RAIN('\uF743'),
    FA_CLOUD_UPLOAD_ALT('\uF382'),
    FA_CLOUDSCALE('\uF383'),
    FA_CLOUDSMITH('\uF384'),
    FA_CLOUDVERSIFY('\uF385'),
    FA_COCKTAIL('\uF561'),
    FA_CODE('\uF121'),
    FA_CODE_BRANCH('\uF126'),
    FA_CODEPEN('\uF1CB'),
    FA_CODIEPIE('\uF284'),
    FA_COFFEE('\uF0F4'),
    FA_COG('\uF013'),
    FA_COGS('\uF085'),
    FA_COINS('\uF51E'),
    FA_COLUMNS('\uF0DB'),
    FA_COMMENT('\uF075'),
    FA_COMMENT_ALT('\uF27A'),
    FA_COMMENT_DOLLAR('\uF651'),
    FA_COMMENT_DOTS('\uF4AD'),
    FA_COMMENT_SLASH('\uF4B3'),
    FA_COMMENTS('\uF086'),
    FA_COMMENTS_DOLLAR('\uF653'),
    FA_COMPACT_DISC('\uF51F'),
    FA_COMPASS('\uF14E'),
    FA_COMPRESS('\uF066'),
    FA_COMPRESS_ARROWS_ALT('\uF78C'),
    FA_CONCIERGE_BELL('\uF562'),
    FA_CONFLUENCE('\uF78D'),
    FA_CONNECTDEVELOP('\uF20E'),
    FA_CONTAO('\uF26D'),
    FA_COOKIE('\uF563'),
    FA_COOKIE_BITE('\uF564'),
    FA_COPY('\uF0C5'),
    FA_COPYRIGHT('\uF1F9'),
    FA_COUCH('\uF4B8'),
    FA_CPANEL('\uF388'),
    FA_CREATIVE_COMMONS('\uF25E'),
    FA_CREATIVE_COMMONS_BY('\uF4E7'),
    FA_CREATIVE_COMMONS_NC('\uF4E8'),
    FA_CREATIVE_COMMONS_NC_EU('\uF4E9'),
    FA_CREATIVE_COMMONS_NC_JP('\uF4EA'),
    FA_CREATIVE_COMMONS_ND('\uF4EB'),
    FA_CREATIVE_COMMONS_PD('\uF4EC'),
    FA_CREATIVE_COMMONS_PD_ALT('\uF4ED'),
    FA_CREATIVE_COMMONS_REMIX('\uF4EE'),
    FA_CREATIVE_COMMONS_SA('\uF4EF'),
    FA_CREATIVE_COMMONS_SAMPLING('\uF4F0'),
    FA_CREATIVE_COMMONS_SAMPLING_PLUS('\uF4F1'),
    FA_CREATIVE_COMMONS_SHARE('\uF4F2'),
    FA_CREATIVE_COMMONS_ZERO('\uF4F3'),
    FA_CREDIT_CARD('\uF09D'),
    FA_CRITICAL_ROLE('\uF6C9'),
    FA_CROP('\uF125'),
    FA_CROP_ALT('\uF565'),
    FA_CROSS('\uF654'),
    FA_CROSSHAIRS('\uF05B'),
    FA_CROW('\uF520'),
    FA_CROWN('\uF521'),
    FA_CSS3('\uF13C'),
    FA_CSS3_ALT('\uF38B'),
    FA_CUBE('\uF1B2'),
    FA_CUBES('\uF1B3'),
    FA_CUT('\uF0C4'),
    FA_CUTTLEFISH('\uF38C'),
    FA_D_AND_D('\uF38D'),
    FA_D_AND_D_BEYOND('\uF6CA'),
    FA_DASHCUBE('\uF210'),
    FA_DATABASE('\uF1C0'),
    FA_DEAF('\uF2A4'),
    FA_DELICIOUS('\uF1A5'),
    FA_DEMOCRAT('\uF747'),
    FA_DEPLOYDOG('\uF38E'),
    FA_DESKPRO('\uF38F'),
    FA_DESKTOP('\uF108'),
    FA_DEV('\uF6CC'),
    FA_DEVIANTART('\uF1BD'),
    FA_DHARMACHAKRA('\uF655'),
    FA_DHL('\uF790'),
    FA_DIAGNOSES('\uF470'),
    FA_DIASPORA('\uF791'),
    FA_DICE('\uF522'),
    FA_DICE_D20('\uF6CF'),
    FA_DICE_D6('\uF6D1'),
    FA_DICE_FIVE('\uF523'),
    FA_DICE_FOUR('\uF524'),
    FA_DICE_ONE('\uF525'),
    FA_DICE_SIX('\uF526'),
    FA_DICE_THREE('\uF527'),
    FA_DICE_TWO('\uF528'),
    FA_DIGG('\uF1A6'),
    FA_DIGITAL_OCEAN('\uF391'),
    FA_DIGITAL_TACHOGRAPH('\uF566'),
    FA_DIRECTIONS('\uF5EB'),
    FA_DISCORD('\uF392'),
    FA_DISCOURSE('\uF393'),
    FA_DIVIDE('\uF529'),
    FA_DIZZY('\uF567'),
    FA_DNA('\uF471'),
    FA_DOCHUB('\uF394'),
    FA_DOCKER('\uF395'),
    FA_DOG('\uF6D3'),
    FA_DOLLAR_SIGN('\uF155'),
    FA_DOLLY('\uF472'),
    FA_DOLLY_FLATBED('\uF474'),
    FA_DONATE('\uF4B9'),
    FA_DOOR_CLOSED('\uF52A'),
    FA_DOOR_OPEN('\uF52B'),
    FA_DOT_CIRCLE('\uF192'),
    FA_DOVE('\uF4BA'),
    FA_DOWNLOAD('\uF019'),
    FA_DRAFT2DIGITAL('\uF396'),
    FA_DRAFTING_COMPASS('\uF568'),
    FA_DRAGON('\uF6D5'),
    FA_DRAW_POLYGON('\uF5EE'),
    FA_DRIBBBLE('\uF17D'),
    FA_DRIBBBLE_SQUARE('\uF397'),
    FA_DROPBOX('\uF16B'),
    FA_DRUM('\uF569'),
    FA_DRUM_STEELPAN('\uF56A'),
    FA_DRUMSTICK_BITE('\uF6D7'),
    FA_DRUPAL('\uF1A9'),
    FA_DUMBBELL('\uF44B'),
    FA_DUMPSTER('\uF793'),
    FA_DUMPSTER_FIRE('\uF794'),
    FA_DUNGEON('\uF6D9'),
    FA_DYALOG('\uF399'),
    FA_EARLYBIRDS('\uF39A'),
    FA_EBAY('\uF4F4'),
    FA_EDGE('\uF282'),
    FA_EDIT('\uF044'),
    FA_EJECT('\uF052'),
    FA_ELEMENTOR('\uF430'),
    FA_ELLIPSIS_H('\uF141'),
    FA_ELLIPSIS_V('\uF142'),
    FA_ELLO('\uF5F1'),
    FA_EMBER('\uF423'),
    FA_EMPIRE('\uF1D1'),
    FA_ENVELOPE('\uF0E0'),
    FA_ENVELOPE_OPEN('\uF2B6'),
    FA_ENVELOPE_OPEN_TEXT('\uF658'),
    FA_ENVELOPE_SQUARE('\uF199'),
    FA_ENVIRA('\uF299'),
    FA_EQUALS('\uF52C'),
    FA_ERASER('\uF12D'),
    FA_ERLANG('\uF39D'),
    FA_ETHEREUM('\uF42E'),
    FA_ETHERNET('\uF796'),
    FA_ETSY('\uF2D7'),
    FA_EURO_SIGN('\uF153'),
    FA_EXCHANGE_ALT('\uF362'),
    FA_EXCLAMATION('\uF12A'),
    FA_EXCLAMATION_CIRCLE('\uF06A'),
    FA_EXCLAMATION_TRIANGLE('\uF071'),
    FA_EXPAND('\uF065'),
    FA_EXPAND_ARROWS_ALT('\uF31E'),
    FA_EXPEDITEDSSL('\uF23E'),
    FA_EXTERNAL_LINK_ALT('\uF35D'),
    FA_EXTERNAL_LINK_SQUARE_ALT('\uF360'),
    FA_EYE('\uF06E'),
    FA_EYE_DROPPER('\uF1FB'),
    FA_EYE_SLASH('\uF070'),
    FA_FACEBOOK('\uF09A'),
    FA_FACEBOOK_F('\uF39E'),
    FA_FACEBOOK_MESSENGER('\uF39F'),
    FA_FACEBOOK_SQUARE('\uF082'),
    FA_FANTASY_FLIGHT_GAMES('\uF6DC'),
    FA_FAST_BACKWARD('\uF049'),
    FA_FAST_FORWARD('\uF050'),
    FA_FAX('\uF1AC'),
    FA_FEATHER('\uF52D'),
    FA_FEATHER_ALT('\uF56B'),
    FA_FEDEX('\uF797'),
    FA_FEDORA('\uF798'),
    FA_FEMALE('\uF182'),
    FA_FIGHTER_JET('\uF0FB'),
    FA_FIGMA('\uF799'),
    FA_FILE('\uF15B'),
    FA_FILE_ALT('\uF15C'),
    FA_FILE_ARCHIVE('\uF1C6'),
    FA_FILE_AUDIO('\uF1C7'),
    FA_FILE_CODE('\uF1C9'),
    FA_FILE_CONTRACT('\uF56C'),
    FA_FILE_CSV('\uF6DD'),
    FA_FILE_DOWNLOAD('\uF56D'),
    FA_FILE_EXCEL('\uF1C3'),
    FA_FILE_EXPORT('\uF56E'),
    FA_FILE_IMAGE('\uF1C5'),
    FA_FILE_IMPORT('\uF56F'),
    FA_FILE_INVOICE('\uF570'),
    FA_FILE_INVOICE_DOLLAR('\uF571'),
    FA_FILE_MEDICAL('\uF477'),
    FA_FILE_MEDICAL_ALT('\uF478'),
    FA_FILE_PDF('\uF1C1'),
    FA_FILE_POWERPOINT('\uF1C4'),
    FA_FILE_PRESCRIPTION('\uF572'),
    FA_FILE_SIGNATURE('\uF573'),
    FA_FILE_UPLOAD('\uF574'),
    FA_FILE_VIDEO('\uF1C8'),
    FA_FILE_WORD('\uF1C2'),
    FA_FILL('\uF575'),
    FA_FILL_DRIP('\uF576'),
    FA_FILM('\uF008'),
    FA_FILTER('\uF0B0'),
    FA_FINGERPRINT('\uF577'),
    FA_FIRE('\uF06D'),
    FA_FIRE_ALT('\uF7E4'),
    FA_FIRE_EXTINGUISHER('\uF134'),
    FA_FIREFOX('\uF269'),
    FA_FIRST_AID('\uF479'),
    FA_FIRST_ORDER('\uF2B0'),
    FA_FIRST_ORDER_ALT('\uF50A'),
    FA_FIRSTDRAFT('\uF3A1'),
    FA_FISH('\uF578'),
    FA_FIST_RAISED('\uF6DE'),
    FA_FLAG('\uF024'),
    FA_FLAG_CHECKERED('\uF11E'),
    FA_FLAG_USA('\uF74D'),
    FA_FLASK('\uF0C3'),
    FA_FLICKR('\uF16E'),
    FA_FLIPBOARD('\uF44D'),
    FA_FLUSHED('\uF579'),
    FA_FLY('\uF417'),
    FA_FOLDER('\uF07B'),
    FA_FOLDER_MINUS('\uF65D'),
    FA_FOLDER_OPEN('\uF07C'),
    FA_FOLDER_PLUS('\uF65E'),
    FA_FONT('\uF031'),
    FA_FONT_AWESOME('\uF2B4'),
    FA_FONT_AWESOME_ALT('\uF35C'),
    FA_FONT_AWESOME_FLAG('\uF425'),
    FA_FONT_AWESOME_LOGO_FULL('\uF4E6'),
    FA_FONTICONS('\uF280'),
    FA_FONTICONS_FI('\uF3A2'),
    FA_FOOTBALL_BALL('\uF44E'),
    FA_FORT_AWESOME('\uF286'),
    FA_FORT_AWESOME_ALT('\uF3A3'),
    FA_FORUMBEE('\uF211'),
    FA_FORWARD('\uF04E'),
    FA_FOURSQUARE('\uF180'),
    FA_FREE_CODE_CAMP('\uF2C5'),
    FA_FREEBSD('\uF3A4'),
    FA_FROG('\uF52E'),
    FA_FROWN('\uF119'),
    FA_FROWN_OPEN('\uF57A'),
    FA_FULCRUM('\uF50B'),
    FA_FUNNEL_DOLLAR('\uF662'),
    FA_FUTBOL('\uF1E3'),
    FA_GALACTIC_REPUBLIC('\uF50C'),
    FA_GALACTIC_SENATE('\uF50D'),
    FA_GAMEPAD('\uF11B'),
    FA_GAS_PUMP('\uF52F'),
    FA_GAVEL('\uF0E3'),
    FA_GEM('\uF3A5'),
    FA_GENDERLESS('\uF22D'),
    FA_GET_POCKET('\uF265'),
    FA_GG('\uF260'),
    FA_GG_CIRCLE('\uF261'),
    FA_GHOST('\uF6E2'),
    FA_GIFT('\uF06B'),
    FA_GIFTS('\uF79C'),
    FA_GIT('\uF1D3'),
    FA_GIT_SQUARE('\uF1D2'),
    FA_GITHUB('\uF09B'),
    FA_GITHUB_ALT('\uF113'),
    FA_GITHUB_SQUARE('\uF092'),
    FA_GITKRAKEN('\uF3A6'),
    FA_GITLAB('\uF296'),
    FA_GITTER('\uF426'),
    FA_GLASS_CHEERS('\uF79F'),
    FA_GLASS_MARTINI('\uF000'),
    FA_GLASS_MARTINI_ALT('\uF57B'),
    FA_GLASS_WHISKEY('\uF7A0'),
    FA_GLASSES('\uF530'),
    FA_GLIDE('\uF2A5'),
    FA_GLIDE_G('\uF2A6'),
    FA_GLOBE('\uF0AC'),
    FA_GLOBE_AFRICA('\uF57C'),
    FA_GLOBE_AMERICAS('\uF57D'),
    FA_GLOBE_ASIA('\uF57E'),
    FA_GLOBE_EUROPE('\uF7A2'),
    FA_GOFORE('\uF3A7'),
    FA_GOLF_BALL('\uF450'),
    FA_GOODREADS('\uF3A8'),
    FA_GOODREADS_G('\uF3A9'),
    FA_GOOGLE('\uF1A0'),
    FA_GOOGLE_DRIVE('\uF3AA'),
    FA_GOOGLE_PLAY('\uF3AB'),
    FA_GOOGLE_PLUS('\uF2B3'),
    FA_GOOGLE_PLUS_G('\uF0D5'),
    FA_GOOGLE_PLUS_SQUARE('\uF0D4'),
    FA_GOOGLE_WALLET('\uF1EE'),
    FA_GOPURAM('\uF664'),
    FA_GRADUATION_CAP('\uF19D'),
    FA_GRATIPAY('\uF184'),
    FA_GRAV('\uF2D6'),
    FA_GREATER_THAN('\uF531'),
    FA_GREATER_THAN_EQUAL('\uF532'),
    FA_GRIMACE('\uF57F'),
    FA_GRIN('\uF580'),
    FA_GRIN_ALT('\uF581'),
    FA_GRIN_BEAM('\uF582'),
    FA_GRIN_BEAM_SWEAT('\uF583'),
    FA_GRIN_HEARTS('\uF584'),
    FA_GRIN_SQUINT('\uF585'),
    FA_GRIN_SQUINT_TEARS('\uF586'),
    FA_GRIN_STARS('\uF587'),
    FA_GRIN_TEARS('\uF588'),
    FA_GRIN_TONGUE('\uF589'),
    FA_GRIN_TONGUE_SQUINT('\uF58A'),
    FA_GRIN_TONGUE_WINK('\uF58B'),
    FA_GRIN_WINK('\uF58C'),
    FA_GRIP_HORIZONTAL('\uF58D'),
    FA_GRIP_LINES('\uF7A4'),
    FA_GRIP_LINES_VERTICAL('\uF7A5'),
    FA_GRIP_VERTICAL('\uF58E'),
    FA_GRIPFIRE('\uF3AC'),
    FA_GRUNT('\uF3AD'),
    FA_GUITAR('\uF7A6'),
    FA_GULP('\uF3AE'),
    FA_H_SQUARE('\uF0FD'),
    FA_HACKER_NEWS('\uF1D4'),
    FA_HACKER_NEWS_SQUARE('\uF3AF'),
    FA_HACKERRANK('\uF5F7'),
    FA_HAMMER('\uF6E3'),
    FA_HAMSA('\uF665'),
    FA_HAND_HOLDING('\uF4BD'),
    FA_HAND_HOLDING_HEART('\uF4BE'),
    FA_HAND_HOLDING_USD('\uF4C0'),
    FA_HAND_LIZARD('\uF258'),
    FA_HAND_PAPER('\uF256'),
    FA_HAND_PEACE('\uF25B'),
    FA_HAND_POINT_DOWN('\uF0A7'),
    FA_HAND_POINT_LEFT('\uF0A5'),
    FA_HAND_POINT_RIGHT('\uF0A4'),
    FA_HAND_POINT_UP('\uF0A6'),
    FA_HAND_POINTER('\uF25A'),
    FA_HAND_ROCK('\uF255'),
    FA_HAND_SCISSORS('\uF257'),
    FA_HAND_SPOCK('\uF259'),
    FA_HANDS('\uF4C2'),
    FA_HANDS_HELPING('\uF4C4'),
    FA_HANDSHAKE('\uF2B5'),
    FA_HANUKIAH('\uF6E6'),
    FA_HASHTAG('\uF292'),
    FA_HAT_WIZARD('\uF6E8'),
    FA_HAYKAL('\uF666'),
    FA_HDD('\uF0A0'),
    FA_HEADING('\uF1DC'),
    FA_HEADPHONES('\uF025'),
    FA_HEADPHONES_ALT('\uF58F'),
    FA_HEADSET('\uF590'),
    FA_HEART('\uF004'),
    FA_HEART_BROKEN('\uF7A9'),
    FA_HEARTBEAT('\uF21E'),
    FA_HELICOPTER('\uF533'),
    FA_HIGHLIGHTER('\uF591'),
    FA_HIKING('\uF6EC'),
    FA_HIPPO('\uF6ED'),
    FA_HIPS('\uF452'),
    FA_HIRE_A_HELPER('\uF3B0'),
    FA_HISTORY('\uF1DA'),
    FA_HOCKEY_PUCK('\uF453'),
    FA_HOLLY_BERRY('\uF7AA'),
    FA_HOME('\uF015'),
    FA_HOOLI('\uF427'),
    FA_HORNBILL('\uF592'),
    FA_HORSE('\uF6F0'),
    FA_HORSE_HEAD('\uF7AB'),
    FA_HOSPITAL('\uF0F8'),
    FA_HOSPITAL_ALT('\uF47D'),
    FA_HOSPITAL_SYMBOL('\uF47E'),
    FA_HOT_TUB('\uF593'),
    FA_HOTEL('\uF594'),
    FA_HOTJAR('\uF3B1'),
    FA_HOURGLASS('\uF254'),
    FA_HOURGLASS_END('\uF253'),
    FA_HOURGLASS_HALF('\uF252'),
    FA_HOURGLASS_START('\uF251'),
    FA_HOUSE_DAMAGE('\uF6F1'),
    FA_HOUZZ('\uF27C'),
    FA_HRYVNIA('\uF6F2'),
    FA_HTML5('\uF13B'),
    FA_HUBSPOT('\uF3B2'),
    FA_I_CURSOR('\uF246'),
    FA_ICICLES('\uF7AD'),
    FA_ID_BADGE('\uF2C1'),
    FA_ID_CARD('\uF2C2'),
    FA_ID_CARD_ALT('\uF47F'),
    FA_IGLOO('\uF7AE'),
    FA_IMAGE('\uF03E'),
    FA_IMAGES('\uF302'),
    FA_IMDB('\uF2D8'),
    FA_INBOX('\uF01C'),
    FA_INDENT('\uF03C'),
    FA_INDUSTRY('\uF275'),
    FA_INFINITY('\uF534'),
    FA_INFO('\uF129'),
    FA_INFO_CIRCLE('\uF05A'),
    FA_INSTAGRAM('\uF16D'),
    FA_INTERCOM('\uF7AF'),
    FA_INTERNET_EXPLORER('\uF26B'),
    FA_INVISION('\uF7B0'),
    FA_IOXHOST('\uF208'),
    FA_ITALIC('\uF033'),
    FA_ITUNES('\uF3B4'),
    FA_ITUNES_NOTE('\uF3B5'),
    FA_JAVA('\uF4E4'),
    FA_JEDI('\uF669'),
    FA_JEDI_ORDER('\uF50E'),
    FA_JENKINS('\uF3B6'),
    FA_JIRA('\uF7B1'),
    FA_JOGET('\uF3B7'),
    FA_JOINT('\uF595'),
    FA_JOOMLA('\uF1AA'),
    FA_JOURNAL_WHILLS('\uF66A'),
    FA_JS('\uF3B8'),
    FA_JS_SQUARE('\uF3B9'),
    FA_JSFIDDLE('\uF1CC'),
    FA_KAABA('\uF66B'),
    FA_KAGGLE('\uF5FA'),
    FA_KEY('\uF084'),
    FA_KEYBASE('\uF4F5'),
    FA_KEYBOARD('\uF11C'),
    FA_KEYCDN('\uF3BA'),
    FA_KHANDA('\uF66D'),
    FA_KICKSTARTER('\uF3BB'),
    FA_KICKSTARTER_K('\uF3BC'),
    FA_KISS('\uF596'),
    FA_KISS_BEAM('\uF597'),
    FA_KISS_WINK_HEART('\uF598'),
    FA_KIWI_BIRD('\uF535'),
    FA_KORVUE('\uF42F'),
    FA_LANDMARK('\uF66F'),
    FA_LANGUAGE('\uF1AB'),
    FA_LAPTOP('\uF109'),
    FA_LAPTOP_CODE('\uF5FC'),
    FA_LARAVEL('\uF3BD'),
    FA_LASTFM('\uF202'),
    FA_LASTFM_SQUARE('\uF203'),
    FA_LAUGH('\uF599'),
    FA_LAUGH_BEAM('\uF59A'),
    FA_LAUGH_SQUINT('\uF59B'),
    FA_LAUGH_WINK('\uF59C'),
    FA_LAYER_GROUP('\uF5FD'),
    FA_LEAF('\uF06C'),
    FA_LEANPUB('\uF212'),
    FA_LEMON('\uF094'),
    FA_LESS('\uF41D'),
    FA_LESS_THAN('\uF536'),
    FA_LESS_THAN_EQUAL('\uF537'),
    FA_LEVEL_DOWN_ALT('\uF3BE'),
    FA_LEVEL_UP_ALT('\uF3BF'),
    FA_LIFE_RING('\uF1CD'),
    FA_LIGHTBULB('\uF0EB'),
    FA_LINE('\uF3C0'),
    FA_LINK('\uF0C1'),
    FA_LINKEDIN('\uF08C'),
    FA_LINKEDIN_IN('\uF0E1'),
    FA_LINODE('\uF2B8'),
    FA_LINUX('\uF17C'),
    FA_LIRA_SIGN('\uF195'),
    FA_LIST('\uF03A'),
    FA_LIST_ALT('\uF022'),
    FA_LIST_OL('\uF0CB'),
    FA_LIST_UL('\uF0CA'),
    FA_LOCATION_ARROW('\uF124'),
    FA_LOCK('\uF023'),
    FA_LOCK_OPEN('\uF3C1'),
    FA_LONG_ARROW_ALT_DOWN('\uF309'),
    FA_LONG_ARROW_ALT_LEFT('\uF30A'),
    FA_LONG_ARROW_ALT_RIGHT('\uF30B'),
    FA_LONG_ARROW_ALT_UP('\uF30C'),
    FA_LOW_VISION('\uF2A8'),
    FA_LUGGAGE_CART('\uF59D'),
    FA_LYFT('\uF3C3'),
    FA_MAGENTO('\uF3C4'),
    FA_MAGIC('\uF0D0'),
    FA_MAGNET('\uF076'),
    FA_MAIL_BULK('\uF674'),
    FA_MAILCHIMP('\uF59E'),
    FA_MALE('\uF183'),
    FA_MANDALORIAN('\uF50F'),
    FA_MAP('\uF279'),
    FA_MAP_MARKED('\uF59F'),
    FA_MAP_MARKED_ALT('\uF5A0'),
    FA_MAP_MARKER('\uF041'),
    FA_MAP_MARKER_ALT('\uF3C5'),
    FA_MAP_PIN('\uF276'),
    FA_MAP_SIGNS('\uF277'),
    FA_MARKDOWN('\uF60F'),
    FA_MARKER('\uF5A1'),
    FA_MARS('\uF222'),
    FA_MARS_DOUBLE('\uF227'),
    FA_MARS_STROKE('\uF229'),
    FA_MARS_STROKE_H('\uF22B'),
    FA_MARS_STROKE_V('\uF22A'),
    FA_MASK('\uF6FA'),
    FA_MASTODON('\uF4F6'),
    FA_MAXCDN('\uF136'),
    FA_MEDAL('\uF5A2'),
    FA_MEDAPPS('\uF3C6'),
    FA_MEDIUM('\uF23A'),
    FA_MEDIUM_M('\uF3C7'),
    FA_MEDKIT('\uF0FA'),
    FA_MEDRT('\uF3C8'),
    FA_MEETUP('\uF2E0'),
    FA_MEGAPORT('\uF5A3'),
    FA_MEH('\uF11A'),
    FA_MEH_BLANK('\uF5A4'),
    FA_MEH_ROLLING_EYES('\uF5A5'),
    FA_MEMORY('\uF538'),
    FA_MENDELEY('\uF7B3'),
    FA_MENORAH('\uF676'),
    FA_MERCURY('\uF223'),
    FA_METEOR('\uF753'),
    FA_MICROCHIP('\uF2DB'),
    FA_MICROPHONE('\uF130'),
    FA_MICROPHONE_ALT('\uF3C9'),
    FA_MICROPHONE_ALT_SLASH('\uF539'),
    FA_MICROPHONE_SLASH('\uF131'),
    FA_MICROSCOPE('\uF610'),
    FA_MICROSOFT('\uF3CA'),
    FA_MINUS('\uF068'),
    FA_MINUS_CIRCLE('\uF056'),
    FA_MINUS_SQUARE('\uF146'),
    FA_MITTEN('\uF7B5'),
    FA_MIX('\uF3CB'),
    FA_MIXCLOUD('\uF289'),
    FA_MIZUNI('\uF3CC'),
    FA_MOBILE('\uF10B'),
    FA_MOBILE_ALT('\uF3CD'),
    FA_MODX('\uF285'),
    FA_MONERO('\uF3D0'),
    FA_MONEY_BILL('\uF0D6'),
    FA_MONEY_BILL_ALT('\uF3D1'),
    FA_MONEY_BILL_WAVE('\uF53A'),
    FA_MONEY_BILL_WAVE_ALT('\uF53B'),
    FA_MONEY_CHECK('\uF53C'),
    FA_MONEY_CHECK_ALT('\uF53D'),
    FA_MONUMENT('\uF5A6'),
    FA_MOON('\uF186'),
    FA_MORTAR_PESTLE('\uF5A7'),
    FA_MOSQUE('\uF678'),
    FA_MOTORCYCLE('\uF21C'),
    FA_MOUNTAIN('\uF6FC'),
    FA_MOUSE_POINTER('\uF245'),
    FA_MUG_HOT('\uF7B6'),
    FA_MUSIC('\uF001'),
    FA_NAPSTER('\uF3D2'),
    FA_NEOS('\uF612'),
    FA_NETWORK_WIRED('\uF6FF'),
    FA_NEUTER('\uF22C'),
    FA_NEWSPAPER('\uF1EA'),
    FA_NIMBLR('\uF5A8'),
    FA_NINTENDO_SWITCH('\uF418'),
    FA_NODE('\uF419'),
    FA_NODE_JS('\uF3D3'),
    FA_NOT_EQUAL('\uF53E'),
    FA_NOTES_MEDICAL('\uF481'),
    FA_NPM('\uF3D4'),
    FA_NS8('\uF3D5'),
    FA_NUTRITIONIX('\uF3D6'),
    FA_OBJECT_GROUP('\uF247'),
    FA_OBJECT_UNGROUP('\uF248'),
    FA_ODNOKLASSNIKI('\uF263'),
    FA_ODNOKLASSNIKI_SQUARE('\uF264'),
    FA_OIL_CAN('\uF613'),
    FA_OLD_REPUBLIC('\uF510'),
    FA_OM('\uF679'),
    FA_OPENCART('\uF23D'),
    FA_OPENID('\uF19B'),
    FA_OPERA('\uF26A'),
    FA_OPTIN_MONSTER('\uF23C'),
    FA_OSI('\uF41A'),
    FA_OTTER('\uF700'),
    FA_OUTDENT('\uF03B'),
    FA_PAGE4('\uF3D7'),
    FA_PAGELINES('\uF18C'),
    FA_PAINT_BRUSH('\uF1FC'),
    FA_PAINT_ROLLER('\uF5AA'),
    FA_PALETTE('\uF53F'),
    FA_PALFED('\uF3D8'),
    FA_PALLET('\uF482'),
    FA_PAPER_PLANE('\uF1D8'),
    FA_PAPERCLIP('\uF0C6'),
    FA_PARACHUTE_BOX('\uF4CD'),
    FA_PARAGRAPH('\uF1DD'),
    FA_PARKING('\uF540'),
    FA_PASSPORT('\uF5AB'),
    FA_PASTAFARIANISM('\uF67B'),
    FA_PASTE('\uF0EA'),
    FA_PATREON('\uF3D9'),
    FA_PAUSE('\uF04C'),
    FA_PAUSE_CIRCLE('\uF28B'),
    FA_PAW('\uF1B0'),
    FA_PAYPAL('\uF1ED'),
    FA_PEACE('\uF67C'),
    FA_PEN('\uF304'),
    FA_PEN_ALT('\uF305'),
    FA_PEN_FANCY('\uF5AC'),
    FA_PEN_NIB('\uF5AD'),
    FA_PEN_SQUARE('\uF14B'),
    FA_PENCIL_ALT('\uF303'),
    FA_PENCIL_RULER('\uF5AE'),
    FA_PENNY_ARCADE('\uF704'),
    FA_PEOPLE_CARRY('\uF4CE'),
    FA_PERCENT('\uF295'),
    FA_PERCENTAGE('\uF541'),
    FA_PERISCOPE('\uF3DA'),
    FA_PERSON_BOOTH('\uF756'),
    FA_PHABRICATOR('\uF3DB'),
    FA_PHOENIX_FRAMEWORK('\uF3DC'),
    FA_PHOENIX_SQUADRON('\uF511'),
    FA_PHONE('\uF095'),
    FA_PHONE_SLASH('\uF3DD'),
    FA_PHONE_SQUARE('\uF098'),
    FA_PHONE_VOLUME('\uF2A0'),
    FA_PHP('\uF457'),
    FA_PIED_PIPER('\uF2AE'),
    FA_PIED_PIPER_ALT('\uF1A8'),
    FA_PIED_PIPER_HAT('\uF4E5'),
    FA_PIED_PIPER_PP('\uF1A7'),
    FA_PIGGY_BANK('\uF4D3'),
    FA_PILLS('\uF484'),
    FA_PINTEREST('\uF0D2'),
    FA_PINTEREST_P('\uF231'),
    FA_PINTEREST_SQUARE('\uF0D3'),
    FA_PLACE_OF_WORSHIP('\uF67F'),
    FA_PLANE('\uF072'),
    FA_PLANE_ARRIVAL('\uF5AF'),
    FA_PLANE_DEPARTURE('\uF5B0'),
    FA_PLAY('\uF04B'),
    FA_PLAY_CIRCLE('\uF144'),
    FA_PLAYSTATION('\uF3DF'),
    FA_PLUG('\uF1E6'),
    FA_PLUS('\uF067'),
    FA_PLUS_CIRCLE('\uF055'),
    FA_PLUS_SQUARE('\uF0FE'),
    FA_PODCAST('\uF2CE'),
    FA_POLL('\uF681'),
    FA_POLL_H('\uF682'),
    FA_POO('\uF2FE'),
    FA_POO_STORM('\uF75A'),
    FA_POOP('\uF619'),
    FA_PORTRAIT('\uF3E0'),
    FA_POUND_SIGN('\uF154'),
    FA_POWER_OFF('\uF011'),
    FA_PRAY('\uF683'),
    FA_PRAYING_HANDS('\uF684'),
    FA_PRESCRIPTION('\uF5B1'),
    FA_PRESCRIPTION_BOTTLE('\uF485'),
    FA_PRESCRIPTION_BOTTLE_ALT('\uF486'),
    FA_PRINT('\uF02F'),
    FA_PROCEDURES('\uF487'),
    FA_PRODUCT_HUNT('\uF288'),
    FA_PROJECT_DIAGRAM('\uF542'),
    FA_PUSHED('\uF3E1'),
    FA_PUZZLE_PIECE('\uF12E'),
    FA_PYTHON('\uF3E2'),
    FA_QQ('\uF1D6'),
    FA_QRCODE('\uF029'),
    FA_QUESTION('\uF128'),
    FA_QUESTION_CIRCLE('\uF059'),
    FA_QUIDDITCH('\uF458'),
    FA_QUINSCAPE('\uF459'),
    FA_QUORA('\uF2C4'),
    FA_QUOTE_LEFT('\uF10D'),
    FA_QUOTE_RIGHT('\uF10E'),
    FA_QURAN('\uF687'),
    FA_R_PROJECT('\uF4F7'),
    FA_RADIATION('\uF7B9'),
    FA_RADIATION_ALT('\uF7BA'),
    FA_RAINBOW('\uF75B'),
    FA_RANDOM('\uF074'),
    FA_RASPBERRY_PI('\uF7BB'),
    FA_RAVELRY('\uF2D9'),
    FA_REACT('\uF41B'),
    FA_REACTEUROPE('\uF75D'),
    FA_README('\uF4D5'),
    FA_REBEL('\uF1D0'),
    FA_RECEIPT('\uF543'),
    FA_RECYCLE('\uF1B8'),
    FA_RED_RIVER('\uF3E3'),
    FA_REDDIT('\uF1A1'),
    FA_REDDIT_ALIEN('\uF281'),
    FA_REDDIT_SQUARE('\uF1A2'),
    FA_REDHAT('\uF7BC'),
    FA_REDO('\uF01E'),
    FA_REDO_ALT('\uF2F9'),
    FA_REGISTERED('\uF25D'),
    FA_RENREN('\uF18B'),
    FA_REPLY('\uF3E5'),
    FA_REPLY_ALL('\uF122'),
    FA_REPLYD('\uF3E6'),
    FA_REPUBLICAN('\uF75E'),
    FA_RESEARCHGATE('\uF4F8'),
    FA_RESOLVING('\uF3E7'),
    FA_RESTROOM('\uF7BD'),
    FA_RETWEET('\uF079'),
    FA_REV('\uF5B2'),
    FA_RIBBON('\uF4D6'),
    FA_RING('\uF70B'),
    FA_ROAD('\uF018'),
    FA_ROBOT('\uF544'),
    FA_ROCKET('\uF135'),
    FA_ROCKETCHAT('\uF3E8'),
    FA_ROCKRMS('\uF3E9'),
    FA_ROUTE('\uF4D7'),
    FA_RSS('\uF09E'),
    FA_RSS_SQUARE('\uF143'),
    FA_RUBLE_SIGN('\uF158'),
    FA_RULER('\uF545'),
    FA_RULER_COMBINED('\uF546'),
    FA_RULER_HORIZONTAL('\uF547'),
    FA_RULER_VERTICAL('\uF548'),
    FA_RUNNING('\uF70C'),
    FA_RUPEE_SIGN('\uF156'),
    FA_SAD_CRY('\uF5B3'),
    FA_SAD_TEAR('\uF5B4'),
    FA_SAFARI('\uF267'),
    FA_SASS('\uF41E'),
    FA_SATELLITE('\uF7BF'),
    FA_SATELLITE_DISH('\uF7C0'),
    FA_SAVE('\uF0C7'),
    FA_SCHLIX('\uF3EA'),
    FA_SCHOOL('\uF549'),
    FA_SCREWDRIVER('\uF54A'),
    FA_SCRIBD('\uF28A'),
    FA_SCROLL('\uF70E'),
    FA_SD_CARD('\uF7C2'),
    FA_SEARCH('\uF002'),
    FA_SEARCH_DOLLAR('\uF688'),
    FA_SEARCH_LOCATION('\uF689'),
    FA_SEARCH_MINUS('\uF010'),
    FA_SEARCH_PLUS('\uF00E'),
    FA_SEARCHENGIN('\uF3EB'),
    FA_SEEDLING('\uF4D8'),
    FA_SELLCAST('\uF2DA'),
    FA_SELLSY('\uF213'),
    FA_SERVER('\uF233'),
    FA_SERVICESTACK('\uF3EC'),
    FA_SHAPES('\uF61F'),
    FA_SHARE('\uF064'),
    FA_SHARE_ALT('\uF1E0'),
    FA_SHARE_ALT_SQUARE('\uF1E1'),
    FA_SHARE_SQUARE('\uF14D'),
    FA_SHEKEL_SIGN('\uF20B'),
    FA_SHIELD_ALT('\uF3ED'),
    FA_SHIP('\uF21A'),
    FA_SHIPPING_FAST('\uF48B'),
    FA_SHIRTSINBULK('\uF214'),
    FA_SHOE_PRINTS('\uF54B'),
    FA_SHOPPING_BAG('\uF290'),
    FA_SHOPPING_BASKET('\uF291'),
    FA_SHOPPING_CART('\uF07A'),
    FA_SHOPWARE('\uF5B5'),
    FA_SHOWER('\uF2CC'),
    FA_SHUTTLE_VAN('\uF5B6'),
    FA_SIGN('\uF4D9'),
    FA_SIGN_IN_ALT('\uF2F6'),
    FA_SIGN_LANGUAGE('\uF2A7'),
    FA_SIGN_OUT_ALT('\uF2F5'),
    FA_SIGNAL('\uF012'),
    FA_SIGNATURE('\uF5B7'),
    FA_SIM_CARD('\uF7C4'),
    FA_SIMPLYBUILT('\uF215'),
    FA_SISTRIX('\uF3EE'),
    FA_SITEMAP('\uF0E8'),
    FA_SITH('\uF512'),
    FA_SKATING('\uF7C5'),
    FA_SKETCH('\uF7C6'),
    FA_SKIING('\uF7C9'),
    FA_SKIING_NORDIC('\uF7CA'),
    FA_SKULL('\uF54C'),
    FA_SKULL_CROSSBONES('\uF714'),
    FA_SKYATLAS('\uF216'),
    FA_SKYPE('\uF17E'),
    FA_SLACK('\uF198'),
    FA_SLACK_HASH('\uF3EF'),
    FA_SLASH('\uF715'),
    FA_SLEIGH('\uF7CC'),
    FA_SLIDERS_H('\uF1DE'),
    FA_SLIDESHARE('\uF1E7'),
    FA_SMILE('\uF118'),
    FA_SMILE_BEAM('\uF5B8'),
    FA_SMILE_WINK('\uF4DA'),
    FA_SMOG('\uF75F'),
    FA_SMOKING('\uF48D'),
    FA_SMOKING_BAN('\uF54D'),
    FA_SMS('\uF7CD'),
    FA_SNAPCHAT('\uF2AB'),
    FA_SNAPCHAT_GHOST('\uF2AC'),
    FA_SNAPCHAT_SQUARE('\uF2AD'),
    FA_SNOWBOARDING('\uF7CE'),
    FA_SNOWFLAKE('\uF2DC'),
    FA_SNOWMAN('\uF7D0'),
    FA_SNOWPLOW('\uF7D2'),
    FA_SOCKS('\uF696'),
    FA_SOLAR_PANEL('\uF5BA'),
    FA_SORT('\uF0DC'),
    FA_SORT_ALPHA_DOWN('\uF15D'),
    FA_SORT_ALPHA_UP('\uF15E'),
    FA_SORT_AMOUNT_DOWN('\uF160'),
    FA_SORT_AMOUNT_UP('\uF161'),
    FA_SORT_DOWN('\uF0DD'),
    FA_SORT_NUMERIC_DOWN('\uF162'),
    FA_SORT_NUMERIC_UP('\uF163'),
    FA_SORT_UP('\uF0DE'),
    FA_SOUNDCLOUD('\uF1BE'),
    FA_SOURCETREE('\uF7D3'),
    FA_SPA('\uF5BB'),
    FA_SPACE_SHUTTLE('\uF197'),
    FA_SPEAKAP('\uF3F3'),
    FA_SPIDER('\uF717'),
    FA_SPINNER('\uF110'),
    FA_SPLOTCH('\uF5BC'),
    FA_SPOTIFY('\uF1BC'),
    FA_SPRAY_CAN('\uF5BD'),
    FA_SQUARE('\uF0C8'),
    FA_SQUARE_FULL('\uF45C'),
    FA_SQUARE_ROOT_ALT('\uF698'),
    FA_SQUARESPACE('\uF5BE'),
    FA_STACK_EXCHANGE('\uF18D'),
    FA_STACK_OVERFLOW('\uF16C'),
    FA_STAMP('\uF5BF'),
    FA_STAR('\uF005'),
    FA_STAR_AND_CRESCENT('\uF699'),
    FA_STAR_HALF('\uF089'),
    FA_STAR_HALF_ALT('\uF5C0'),
    FA_STAR_OF_DAVID('\uF69A'),
    FA_STAR_OF_LIFE('\uF621'),
    FA_STAYLINKED('\uF3F5'),
    FA_STEAM('\uF1B6'),
    FA_STEAM_SQUARE('\uF1B7'),
    FA_STEAM_SYMBOL('\uF3F6'),
    FA_STEP_BACKWARD('\uF048'),
    FA_STEP_FORWARD('\uF051'),
    FA_STETHOSCOPE('\uF0F1'),
    FA_STICKER_MULE('\uF3F7'),
    FA_STICKY_NOTE('\uF249'),
    FA_STOP('\uF04D'),
    FA_STOP_CIRCLE('\uF28D'),
    FA_STOPWATCH('\uF2F2'),
    FA_STORE('\uF54E'),
    FA_STORE_ALT('\uF54F'),
    FA_STRAVA('\uF428'),
    FA_STREAM('\uF550'),
    FA_STREET_VIEW('\uF21D'),
    FA_STRIKETHROUGH('\uF0CC'),
    FA_STRIPE('\uF429'),
    FA_STRIPE_S('\uF42A'),
    FA_STROOPWAFEL('\uF551'),
    FA_STUDIOVINARI('\uF3F8'),
    FA_STUMBLEUPON('\uF1A4'),
    FA_STUMBLEUPON_CIRCLE('\uF1A3'),
    FA_SUBSCRIPT('\uF12C'),
    FA_SUBWAY('\uF239'),
    FA_SUITCASE('\uF0F2'),
    FA_SUITCASE_ROLLING('\uF5C1'),
    FA_SUN('\uF185'),
    FA_SUPERPOWERS('\uF2DD'),
    FA_SUPERSCRIPT('\uF12B'),
    FA_SUPPLE('\uF3F9'),
    FA_SURPRISE('\uF5C2'),
    FA_SUSE('\uF7D6'),
    FA_SWATCHBOOK('\uF5C3'),
    FA_SWIMMER('\uF5C4'),
    FA_SWIMMING_POOL('\uF5C5'),
    FA_SYNAGOGUE('\uF69B'),
    FA_SYNC('\uF021'),
    FA_SYNC_ALT('\uF2F1'),
    FA_SYRINGE('\uF48E'),
    FA_TABLE('\uF0CE'),
    FA_TABLE_TENNIS('\uF45D'),
    FA_TABLET('\uF10A'),
    FA_TABLET_ALT('\uF3FA'),
    FA_TABLETS('\uF490'),
    FA_TACHOMETER_ALT('\uF3FD'),
    FA_TAG('\uF02B'),
    FA_TAGS('\uF02C'),
    FA_TAPE('\uF4DB'),
    FA_TASKS('\uF0AE'),
    FA_TAXI('\uF1BA'),
    FA_TEAMSPEAK('\uF4F9'),
    FA_TEETH('\uF62E'),
    FA_TEETH_OPEN('\uF62F'),
    FA_TELEGRAM('\uF2C6'),
    FA_TELEGRAM_PLANE('\uF3FE'),
    FA_TEMPERATURE_HIGH('\uF769'),
    FA_TEMPERATURE_LOW('\uF76B'),
    FA_TENCENT_WEIBO('\uF1D5'),
    FA_TENGE('\uF7D7'),
    FA_TERMINAL('\uF120'),
    FA_TEXT_HEIGHT('\uF034'),
    FA_TEXT_WIDTH('\uF035'),
    FA_TH('\uF00A'),
    FA_TH_LARGE('\uF009'),
    FA_TH_LIST('\uF00B'),
    FA_THE_RED_YETI('\uF69D'),
    FA_THEATER_MASKS('\uF630'),
    FA_THEMECO('\uF5C6'),
    FA_THEMEISLE('\uF2B2'),
    FA_THERMOMETER('\uF491'),
    FA_THERMOMETER_EMPTY('\uF2CB'),
    FA_THERMOMETER_FULL('\uF2C7'),
    FA_THERMOMETER_HALF('\uF2C9'),
    FA_THERMOMETER_QUARTER('\uF2CA'),
    FA_THERMOMETER_THREE_QUARTERS('\uF2C8'),
    FA_THINK_PEAKS('\uF731'),
    FA_THUMBS_DOWN('\uF165'),
    FA_THUMBS_UP('\uF164'),
    FA_THUMBTACK('\uF08D'),
    FA_TICKET_ALT('\uF3FF'),
    FA_TIMES('\uF00D'),
    FA_TIMES_CIRCLE('\uF057'),
    FA_TINT('\uF043'),
    FA_TINT_SLASH('\uF5C7'),
    FA_TIRED('\uF5C8'),
    FA_TOGGLE_OFF('\uF204'),
    FA_TOGGLE_ON('\uF205'),
    FA_TOILET('\uF7D8'),
    FA_TOILET_PAPER('\uF71E'),
    FA_TOOLBOX('\uF552'),
    FA_TOOLS('\uF7D9'),
    FA_TOOTH('\uF5C9'),
    FA_TORAH('\uF6A0'),
    FA_TORII_GATE('\uF6A1'),
    FA_TRACTOR('\uF722'),
    FA_TRADE_FEDERATION('\uF513'),
    FA_TRADEMARK('\uF25C'),
    FA_TRAFFIC_LIGHT('\uF637'),
    FA_TRAIN('\uF238'),
    FA_TRAM('\uF7DA'),
    FA_TRANSGENDER('\uF224'),
    FA_TRANSGENDER_ALT('\uF225'),
    FA_TRASH('\uF1F8'),
    FA_TRASH_ALT('\uF2ED'),
    FA_TREE('\uF1BB'),
    FA_TRELLO('\uF181'),
    FA_TRIPADVISOR('\uF262'),
    FA_TROPHY('\uF091'),
    FA_TRUCK('\uF0D1'),
    FA_TRUCK_LOADING('\uF4DE'),
    FA_TRUCK_MONSTER('\uF63B'),
    FA_TRUCK_MOVING('\uF4DF'),
    FA_TRUCK_PICKUP('\uF63C'),
    FA_TSHIRT('\uF553'),
    FA_TTY('\uF1E4'),
    FA_TUMBLR('\uF173'),
    FA_TUMBLR_SQUARE('\uF174'),
    FA_TV('\uF26C'),
    FA_TWITCH('\uF1E8'),
    FA_TWITTER('\uF099'),
    FA_TWITTER_SQUARE('\uF081'),
    FA_TYPO3('\uF42B'),
    FA_UBER('\uF402'),
    FA_UBUNTU('\uF7DF'),
    FA_UIKIT('\uF403'),
    FA_UMBRELLA('\uF0E9'),
    FA_UMBRELLA_BEACH('\uF5CA'),
    FA_UNDERLINE('\uF0CD'),
    FA_UNDO('\uF0E2'),
    FA_UNDO_ALT('\uF2EA'),
    FA_UNIREGISTRY('\uF404'),
    FA_UNIVERSAL_ACCESS('\uF29A'),
    FA_UNIVERSITY('\uF19C'),
    FA_UNLINK('\uF127'),
    FA_UNLOCK('\uF09C'),
    FA_UNLOCK_ALT('\uF13E'),
    FA_UNTAPPD('\uF405'),
    FA_UPLOAD('\uF093'),
    FA_UPS('\uF7E0'),
    FA_USB('\uF287'),
    FA_USER('\uF007'),
    FA_USER_ALT('\uF406'),
    FA_USER_ALT_SLASH('\uF4FA'),
    FA_USER_ASTRONAUT('\uF4FB'),
    FA_USER_CHECK('\uF4FC'),
    FA_USER_CIRCLE('\uF2BD'),
    FA_USER_CLOCK('\uF4FD'),
    FA_USER_COG('\uF4FE'),
    FA_USER_EDIT('\uF4FF'),
    FA_USER_FRIENDS('\uF500'),
    FA_USER_GRADUATE('\uF501'),
    FA_USER_INJURED('\uF728'),
    FA_USER_LOCK('\uF502'),
    FA_USER_MD('\uF0F0'),
    FA_USER_MINUS('\uF503'),
    FA_USER_NINJA('\uF504'),
    FA_USER_PLUS('\uF234'),
    FA_USER_SECRET('\uF21B'),
    FA_USER_SHIELD('\uF505'),
    FA_USER_SLASH('\uF506'),
    FA_USER_TAG('\uF507'),
    FA_USER_TIE('\uF508'),
    FA_USER_TIMES('\uF235'),
    FA_USERS('\uF0C0'),
    FA_USERS_COG('\uF509'),
    FA_USPS('\uF7E1'),
    FA_USSUNNAH('\uF407'),
    FA_UTENSIL_SPOON('\uF2E5'),
    FA_UTENSILS('\uF2E7'),
    FA_VAADIN('\uF408'),
    FA_VECTOR_SQUARE('\uF5CB'),
    FA_VENUS('\uF221'),
    FA_VENUS_DOUBLE('\uF226'),
    FA_VENUS_MARS('\uF228'),
    FA_VIACOIN('\uF237'),
    FA_VIADEO('\uF2A9'),
    FA_VIADEO_SQUARE('\uF2AA'),
    FA_VIAL('\uF492'),
    FA_VIALS('\uF493'),
    FA_VIBER('\uF409'),
    FA_VIDEO('\uF03D'),
    FA_VIDEO_SLASH('\uF4E2'),
    FA_VIHARA('\uF6A7'),
    FA_VIMEO('\uF40A'),
    FA_VIMEO_SQUARE('\uF194'),
    FA_VIMEO_V('\uF27D'),
    FA_VINE('\uF1CA'),
    FA_VK('\uF189'),
    FA_VNV('\uF40B'),
    FA_VOLLEYBALL_BALL('\uF45F'),
    FA_VOLUME_DOWN('\uF027'),
    FA_VOLUME_MUTE('\uF6A9'),
    FA_VOLUME_OFF('\uF026'),
    FA_VOLUME_UP('\uF028'),
    FA_VOTE_YEA('\uF772'),
    FA_VR_CARDBOARD('\uF729'),
    FA_VUEJS('\uF41F'),
    FA_WALKING('\uF554'),
    FA_WALLET('\uF555'),
    FA_WAREHOUSE('\uF494'),
    FA_WATER('\uF773'),
    FA_WEEBLY('\uF5CC'),
    FA_WEIBO('\uF18A'),
    FA_WEIGHT('\uF496'),
    FA_WEIGHT_HANGING('\uF5CD'),
    FA_WEIXIN('\uF1D7'),
    FA_WHATSAPP('\uF232'),
    FA_WHATSAPP_SQUARE('\uF40C'),
    FA_WHEELCHAIR('\uF193'),
    FA_WHMCS('\uF40D'),
    FA_WIFI('\uF1EB'),
    FA_WIKIPEDIA_W('\uF266'),
    FA_WIND('\uF72E'),
    FA_WINDOW_CLOSE('\uF410'),
    FA_WINDOW_MAXIMIZE('\uF2D0'),
    FA_WINDOW_MINIMIZE('\uF2D1'),
    FA_WINDOW_RESTORE('\uF2D2'),
    FA_WINDOWS('\uF17A'),
    FA_WINE_BOTTLE('\uF72F'),
    FA_WINE_GLASS('\uF4E3'),
    FA_WINE_GLASS_ALT('\uF5CE'),
    FA_WIX('\uF5CF'),
    FA_WIZARDS_OF_THE_COAST('\uF730'),
    FA_WOLF_PACK_BATTALION('\uF514'),
    FA_WON_SIGN('\uF159'),
    FA_WORDPRESS('\uF19A'),
    FA_WORDPRESS_SIMPLE('\uF411'),
    FA_WPBEGINNER('\uF297'),
    FA_WPEXPLORER('\uF2DE'),
    FA_WPFORMS('\uF298'),
    FA_WPRESSR('\uF3E4'),
    FA_WRENCH('\uF0AD'),
    FA_X_RAY('\uF497'),
    FA_XBOX('\uF412'),
    FA_XING('\uF168'),
    FA_XING_SQUARE('\uF169'),
    FA_Y_COMBINATOR('\uF23B'),
    FA_YAHOO('\uF19E'),
    FA_YANDEX('\uF413'),
    FA_YANDEX_INTERNATIONAL('\uF414'),
    FA_YARN('\uF7E3'),
    FA_YELP('\uF1E9'),
    FA_YEN_SIGN('\uF157'),
    FA_YIN_YANG('\uF6AD'),
    FA_YOAST('\uF2B1'),
    FA_YOUTUBE('\uF167'),
    FA_YOUTUBE_SQUARE('\uF431'),
    FA_ZHIHU('\uF63F');

    private final char character;

    FontAwesome5(char character) {
        this.character = character;
    }

    @Override
    public char getUnicode() {
        return character;
    }

    @Override
    public String getFontFamily() {
        return "FontAwesome5";
    }

    public static IconFont getIconFont() {
        return new IconFont() {
            @Override
            public String getFontFamily() {
                return "FontAwesome5";
            }

            @Override
            public InputStream getFontInputStream() {
                return FontAwesome5.class.getResourceAsStream("../../resources/fonts/fa-solid-900.ttf");
            }
        };
    }

    public static IconFont getIconFont(String fuente) {
        return new IconFont() {
            @Override
            public String getFontFamily() {
                return "FontAwesome5";
            }

            @Override
            public InputStream getFontInputStream() {
                String ruta = "../../resources/fonts/fa-";
                if (fuente.equals("bands") || fuente.equals("regular")){
                    ruta += fuente + "-400";
                }

                if (fuente.equals("solid")) {
                    ruta += fuente + "-900";
                }
                return FontAwesome5.class.getResourceAsStream(ruta + ".ttf");
            }
        };
    }

}